package com.example.ej4.modelo

import com.example.ej4.bbdd.Vehiculo

class Usuario (
    var nombre : String,
    var apellidos : String,
    var edad : Int,
    var vehiculos: MutableList<Vehiculo> = mutableListOf()
)
