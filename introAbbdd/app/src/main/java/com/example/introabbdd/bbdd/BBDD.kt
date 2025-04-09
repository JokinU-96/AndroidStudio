package com.example.introabbdd.bbdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Pelicula::class), version = 1, exportSchema = false)
abstract class BBDD : RoomDatabase() {
    abstract fun miDAO(): PeliculaDAO

    companion object {
        @Volatile
        private var INSTANCE: BBDD? = null
        fun getDatabase(context: Context): BBDD {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BBDD::class.java,
                    "pelicula_dataBase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

    // Callback que se ejecuta cuando se crea la base de datos
    private val roomCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
// Insertar los datos iniciales
            val peliculasIniciales = listOf(
                Pelicula(titulo = "Jungla de Cristal I"),
                Pelicula(titulo = "Jungla de Cristal II"),
                Pelicula(titulo = "Pulp Fiction"),
                Pelicula(titulo = "Fast and Furious I"),
                Pelicula(titulo = "Fast and Furious II")
            )
// Inserta las películas iniciales en la base de datos
            val viewModelScope = CoroutineScope(Dispatchers.IO)
            viewModelScope.launch {
// Realizar la operación en segundo plano (p. ej., poblar la base de datos)
                peliculasIniciales.forEach { genero -> INSTANCE?.miDAO()?.insertarPelicula(genero) }
            }
        }
    }
}
