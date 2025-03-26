package com.example.ej4.recyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ej4.modelo.Vehiculo
import com.example.ej4.databinding.RecyclerviewVehiculoBinding

class Adaptador(var vehiculos: MutableList<Vehiculo>):RecyclerView.Adapter<Adaptador.VehiculoVH>(){
    inner class VehiculoVH(val binding: RecyclerviewVehiculoBinding): RecyclerView.ViewHolder(binding.root){
        //Aquí dentro pongo un listener para configurar la acción de los botones.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoVH {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: VehiculoVH, position: Int) {
        TODO("Not yet implemented")
    }
}