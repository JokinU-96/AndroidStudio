package com.example.ej4.modelo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ej4.MainActivity
import com.example.ej4.bbdd.Vehiculo
import com.example.kopa.bbdd.Repositorio
import kotlinx.coroutines.launch

class VM(private val miRepositorio : Repositorio):ViewModel() {
    var vehiculos: LiveData<List<Vehiculo>> = miRepositorio.mostrarVehiculos().asLiveData()
    var usuario: Usuario? = null

    var vehiculoComprado: Vehiculo? = null

    fun mostrarVehiculos() = viewModelScope.launch{
        vehiculos = miRepositorio.mostrarVehiculos().asLiveData()
    }

    fun insertar(miVehiculo: Vehiculo) =viewModelScope.launch{
        miRepositorio.insertar(miVehiculo)
    }
    fun borrar(miVehiculo: Vehiculo) =viewModelScope.launch{
        miRepositorio.borrar(miVehiculo)
    }
    fun modificar(miVehiculo: Vehiculo) =viewModelScope.launch{
        miRepositorio.modificar(miVehiculo)
    }
}

class VehiculoViewModelFactory(private val miRepositorio: Repositorio): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(com.example.ej4.modelo.VM::class.java)){
            @Suppress("UNCHECKED_CAST")
            return VM(miRepositorio) as T
        }
        throw IllegalArgumentException("ViewModel class desconocida")
    }

}