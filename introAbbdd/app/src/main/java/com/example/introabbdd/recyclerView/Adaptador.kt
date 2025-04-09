package com.example.introabbdd.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.introabbdd.bbdd.Pelicula
import com.example.introabbdd.databinding.PeliculaVhLayoutBinding

class Adaptador(val listaPelicula:List<Pelicula>): RecyclerView.Adapter<Adaptador.PeliculaVH>() {
    inner class PeliculaVH(var binding: PeliculaVhLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaVH {
        val binding = PeliculaVhLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculaVH(binding)
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: PeliculaVH, position: Int) {
        holder.binding.pvhtvTitulo.text = listaPelicula[position].titulo
    }
}