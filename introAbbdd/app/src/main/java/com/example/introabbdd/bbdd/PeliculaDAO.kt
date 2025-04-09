package com.example.introabbdd.bbdd
import androidx.room.Dao
import androidx.room.Insert
import  androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PeliculaDAO {
    @Query("SELECT * FROM peliculas ORDER BY titulo")
    fun mostrarPeliculas(): Flow<List<Pelicula>>

    @Insert
    suspend fun insertarPelicula(miPelicula: Pelicula)
}