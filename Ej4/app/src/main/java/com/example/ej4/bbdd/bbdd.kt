package com.example.kopa.bbdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ej4.bbdd.Vehiculo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Vehiculo::class), version = 1, exportSchema = false)
abstract class bbdd: RoomDatabase() {
    abstract fun miDAO(): VehiculoDAO

    companion object {
        @Volatile
        private var INSTANCE: bbdd? = null
        fun getDatabase(context: Context): bbdd {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?:Room.databaseBuilder(
                    context.applicationContext,
                    bbdd::class.java,
                    "bbdd_concesionario"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build().also{ INSTANCE = it }
            }
        }
        // Callback que se ejecuta cuando se crea la base de datos
        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // Insertar los datos iniciales
                val vehiculosIniciales = listOf(
                    Vehiculo(tipoVehiculo = "moto", marcaVehiculo = "Dukati", cilindradaVehiculo = 1250.00),
                    Vehiculo(tipoVehiculo = "moto", marcaVehiculo = "Kawasaki", cilindradaVehiculo = 890.00),
                    Vehiculo(tipoVehiculo = "moto", marcaVehiculo = "BMW", cilindradaVehiculo = 980.00),
                    Vehiculo(tipoVehiculo = "coche", marcaVehiculo = "Nissan", cilindradaVehiculo = 2500.00),
                    Vehiculo(tipoVehiculo = "coche", marcaVehiculo = "Renault", cilindradaVehiculo = 9800.00),
                    Vehiculo(tipoVehiculo = "coche", marcaVehiculo = "Peugeot", cilindradaVehiculo = 15000.00)
                )
                // Inserta las películas iniciales en la base de datos
                val viewModelScope = CoroutineScope(Dispatchers.IO)
                viewModelScope.launch {
                    // Realizar la operación en segundo plano (p. ej., poblar la base de datos)
                    vehiculosIniciales.forEach { vehiculo -> INSTANCE?.miDAO()?.insertar(vehiculo) }
                }
            }
        }
    }


}