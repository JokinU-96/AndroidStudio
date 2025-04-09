package com.example.introabbdd.modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.introabbdd.bbdd.Pelicula
import com.example.introabbdd.bbdd.Repositorio
import kotlinx.coroutines.launch

class VM(val miRespositorio: Repositorio): ViewModel() {
    lateinit var listaPeliculas: LiveData<List<Pelicula>>

    fun mostrarPeliculas() = viewModelScope.launch{
        listaPeliculas = miRespositorio.mostrarPeliculas().asLiveData()
    }

}

class PeliculaViewModelFactory(private val miRepositorio: Repositorio): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VM::class.java)){
            @Suppress("UNCHECKED_CAST")
            return VM(miRepositorio) as T
        }
        throw IllegalArgumentException("ViewModel class desconocida")
    }
}