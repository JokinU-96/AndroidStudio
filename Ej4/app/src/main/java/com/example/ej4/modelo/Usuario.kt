package com.example.ej4.modelo

class Usuario (
    var nombre : String,
    var apellidos : String,
    var edad : Int,
    var vehiculos: MutableList<Vehiculo> = mutableListOf()
)
