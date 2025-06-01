package com.example.ej4.bbdd

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehiculos")
data class Vehiculo(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @NonNull @ColumnInfo (name = "tipoVehiculo") val tipoVehiculo : String = "",
    @NonNull @ColumnInfo (name = "marcaVehiculo") val marcaVehiculo : String = "",
    @NonNull @ColumnInfo (name = "cilindradaVehiculo") val cilindradaVehiculo: Double = 0.0,
) {

}