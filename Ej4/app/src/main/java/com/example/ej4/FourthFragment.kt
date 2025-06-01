package com.example.ej4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ej4.databinding.FragmentFourthBinding
import com.example.ej4.databinding.FragmentThirdBinding
import com.example.ej4.bbdd.Vehiculo
import com.example.ej4.modelo.Usuario
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
        (activity as MainActivity).miViewModel.vehiculos.observe(viewLifecycleOwner) {
            vehiculos ->

            if (posicion==-1) findNavController().popBackStack()
            else{
                var vehiculo = vehiculos[posicion]

                binding.etTipo.setText(vehiculo.tipoVehiculo)
                binding.etCilindrada.setText(vehiculo.cilindradaVehiculo.toString())
                binding.etMarca.setText(vehiculo.marcaVehiculo)

                binding.btnComprar.setOnClickListener{
                    comprar(vehiculo)
                }
            }


        }
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater){
                menuInflater.inflate(R.menu.menu_fragment4, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.comprar -> {
                        var posicion = arguments?.getInt("posicion") ?: -1
                        (activity as MainActivity).miViewModel.vehiculos.observe(viewLifecycleOwner) {
                                vehiculos ->

                            if (posicion==-1) findNavController().popBackStack()
                            else{
                                var vehiculo = vehiculos[posicion]

                                binding.etTipo.setText(vehiculo.tipoVehiculo)
                                binding.etCilindrada.setText(vehiculo.cilindradaVehiculo.toString())
                                binding.etMarca.setText(vehiculo.marcaVehiculo)

                                binding.btnComprar.setOnClickListener{
                                    comprar(vehiculo)
                                }
                            }
                        }
                        true
                    }
                    else -> false // Return false for unhandled items, allowing other MenuProviders to handle them
                }
                return true
            }

            private fun comprar(vehiculo: Vehiculo) {
                (activity as MainActivity).miViewModel.vehiculoComprado = vehiculo

                findNavController().navigate(R.id.action_FourthFragment_to_FirstFragment)
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)


    }



    fun comprar(vehiculo: Vehiculo){

        (activity as MainActivity).miViewModel.vehiculoComprado = vehiculo

        findNavController().navigate(R.id.action_FourthFragment_to_FirstFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}