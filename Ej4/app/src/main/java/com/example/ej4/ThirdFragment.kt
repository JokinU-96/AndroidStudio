package com.example.ej4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.view.forEach
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ej4.databinding.FragmentThirdBinding
import com.example.ej4.bbdd.Vehiculo
import com.example.ej4.recyclerView.Adaptador


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvVehiculos.layoutManager= LinearLayoutManager(context)
        (activity as MainActivity).miViewModel.vehiculos.observe(activity as MainActivity){

            if ((activity as MainActivity).miViewModel.usuario?.edad!! <= 18){
                //Cargar solo las motos
                val vehiculosParaMenores = mutableListOf<Vehiculo>()
                (activity as MainActivity).miViewModel.vehiculos.value?.filterTo(vehiculosParaMenores) { it.tipoVehiculo == "moto" }
                binding.rvVehiculos.adapter= Adaptador(vehiculosParaMenores)
            } else{
                binding.rvVehiculos.adapter= Adaptador(it)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}