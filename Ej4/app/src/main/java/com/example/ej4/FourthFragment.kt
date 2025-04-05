package com.example.ej4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ej4.databinding.FragmentFourthBinding
import com.example.ej4.databinding.FragmentThirdBinding
import com.example.ej4.modelo.Vehiculo
import com.example.ej4.recyclerView.Adaptador
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FourthFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var posicion = arguments?.getInt("posicion") ?: -1
        var vehiculo=(activity as MainActivity).miViewModel.vehiculos[0]

        if (posicion==-1) findNavController().popBackStack()
        else{
            vehiculo=(activity as MainActivity).miViewModel.vehiculos[posicion]
            binding.etTipo.setText(vehiculo.tipoVehiculo)
            binding.etCilindrada.setText(vehiculo.cilindradaVehiculo.toString())
            binding.etMarca.setText(vehiculo.marcaVehiculo)
        }

        binding.btnComprar.setOnClickListener{
            comprar(vehiculo)
        }

    }

    fun comprar(vehiculo: Vehiculo){
        var vehiculoComprado:Vehiculo = Vehiculo(vehiculo.tipoVehiculo , vehiculo.marcaVehiculo, vehiculo.cilindradaVehiculo )

        (activity as MainActivity).miViewModel.vehiculoComprado = vehiculoComprado

        findNavController().navigate(R.id.action_FourthFragment_to_FirstFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}