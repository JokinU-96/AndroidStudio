package com.example.ej4.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ej4.R
import com.example.ej4.ThirdFragment
import com.example.ej4.modelo.Vehiculo
import com.example.ej4.databinding.RecyclerviewVehiculoBinding

class Adaptador(var vehiculos: MutableList<Vehiculo>):RecyclerView.Adapter<Adaptador.VehiculoVH>(){
    inner class VehiculoVH(val binding: RecyclerviewVehiculoBinding): RecyclerView.ViewHolder(binding.root){
        //Aquí dentro pongo un listener para configurar la acción de los botones.
        var posicion: Int = 0
        init {
            binding.rviVerVehiculo.setOnClickListener{
                val miBundle = bundleOf("posicion" to posicion)
                //Llevo al usuario a la ventana donde se muestr más información sobre el vehículo.
                binding.rviVerVehiculo.findNavController().navigate(R.id.action_fourthFragment_to_ThirdFragment /*De donde a donde va*/, miBundle/*miBundle*/)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiculoVH {
        val binding = RecyclerviewVehiculoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehiculoVH(binding)
    }

    override fun getItemCount(): Int {
        return vehiculos.count()
    }

    override fun onBindViewHolder(holder: VehiculoVH, position: Int) {
        holder.binding.rviMarca.text = "${vehiculos[position].marcaVehiculo}"
        holder.posicion = position
    }
}