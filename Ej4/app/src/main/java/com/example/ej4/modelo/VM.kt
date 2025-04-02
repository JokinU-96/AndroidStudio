package com.example.ej4.modelo

import androidx.lifecycle.ViewModel
import com.example.ej4.MainActivity

class VM:ViewModel() {
    var vehiculos: MutableList<Vehiculo> = mutableListOf()
    var usuario: Usuario? = null
}