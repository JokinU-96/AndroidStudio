package com.example.kopa.bbdd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ej4.bbdd.Vehiculo
import kotlinx.coroutines.flow.Flow

@Dao
interface VehiculoDAO {
    @Query("SELECT * FROM vehiculos ORDER BY marcaVehiculo ASC")
    fun mostrarVehiculos(): Flow<List<Vehiculo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(miVehiculo: Vehiculo)
    @Delete
    suspend fun borrar(miVehiculo: Vehiculo)
    @Update
    suspend fun modificar(miVehiculo: Vehiculo)
}