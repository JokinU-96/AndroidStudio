package com.example.ej4.modelo

import androidx.lifecycle.ViewModel
import com.example.ej4.MainActivity

class VM:ViewModel() {
    var vehiculos: MutableList<Vehiculo> = mutableListOf()
    var usuario: Usuario? = null

    fun insertarVehiculos(){
        vehiculos.add(Vehiculo("moto", "Dukati", 1250.00))
        vehiculos.add(Vehiculo("moto", "Kawasaki", 890.00))
        vehiculos.add(Vehiculo("moto", "BMW", 980.00))
        vehiculos.add(Vehiculo("coche", "Nissan", 2500.00))
        vehiculos.add(Vehiculo("coche", "Renault", 9800.00))
        vehiculos.add(Vehiculo("coche", "Peugeot", 15000.00))
    }
}
