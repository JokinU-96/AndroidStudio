package com.example.introabbdd.bbdd

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: PeliculaDAO) {
    fun mostrarPeliculas(): Flow<List<Pelicula>> {
        return miDAO.mostrarPeliculas()
    }

    /*@WorkerThread
    suspend fun insertar(miPelicula: Pelicula){
        miDAO.insertar(miPelicula)
    }
    @WorkerThread
    suspend fun borrar(miPelicula: Pelicula){
        miDAO.borrar(miPelicula)
    }

    @WorkerThread
    suspend fun modificar(miPelicula: Pelicula){
        miDAO.modificar(miPelicula)
    }
    fun buscarPorId(id:Int): Flow<Pelicula>{
        return miDAO.buscarPorId()
    }*/

}