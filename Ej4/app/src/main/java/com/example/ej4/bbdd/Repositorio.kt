package com.example.kopa.bbdd

import androidx.annotation.WorkerThread
import com.example.ej4.bbdd.Vehiculo
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: VehiculoDAO) {

    fun mostrarVehiculos(): Flow<List<Vehiculo>> {
        return miDAO.mostrarVehiculos()
    }

    @WorkerThread
    suspend fun insertar(miVehiculo: Vehiculo){
        miDAO.insertar(miVehiculo)
    }
    @WorkerThread
    suspend fun borrar(miVehiculo: Vehiculo){
        miDAO.borrar(miVehiculo)
    }
    @WorkerThread
    suspend fun modificar(miVehiculo: Vehiculo){
        miDAO.modificar(miVehiculo)
    }

}