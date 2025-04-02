package com.example.recycled_view.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycled_view.databinding.RecyclerviewItemBinding

class Adaptador(var usuarios: MutableList<String>): RecyclerView.Adapter<Adaptador.UsuarioVH>() {
    inner class UsuarioVH(val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){
        var posicion: Int = 0

        init{
            binding.rviSaludar.setOnClickListener {
                binding.rviNombre.text = "Hola ${usuarios[posicion]}"
            }
        }
    }



    //captura la vista que hemos creado (recyclerview_item) y crea una instancia del viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador.UsuarioVH {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioVH(binding)
    }

    override fun getItemCount(): Int {
        return usuarios.count()
    }

    override fun onBindViewHolder(holder: UsuarioVH, position: Int) {
        holder.binding.rviNombre.text = "Usuario ${usuarios[position]}"
    }
}