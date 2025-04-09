package com.example.ej4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.example.ej4.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        binding.btnInsertarDatos.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btnComprar.setOnClickListener{
            if((activity as MainActivity).miViewModel.usuario == null) {
                Toast.makeText(context, "Debes hacer el login antes de comprar un vehículo.", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment)
            }
        }

        (activity as MainActivity).miViewModel.usuario?.let{
            it?.let{
                binding.saludo.text="Bienvenido@ ${it.nombre} ${it.apellidos}"
            }
        }

        if((activity as MainActivity).miViewModel.vehiculoComprado != null){
            val frase = (activity as MainActivity).miViewModel.vehiculoComprado?.tipoVehiculo + ' ' +
                    (activity as MainActivity).miViewModel.vehiculoComprado?.marcaVehiculo + ' ' +
                    (activity as MainActivity).miViewModel.vehiculoComprado?.cilindradaVehiculo
            //Muestro un Toast con los datos del vehículo comprado.
            Toast.makeText(context,frase, Toast.LENGTH_SHORT).show()
        }

        if((activity as MainActivity).miViewModel.usuario != null){
            binding.saludo.text = (activity as MainActivity).miViewModel.usuario?.nombre
        }

    }



    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    val menuHost: MenuHost = requireActivity()

    menuHost.addMenuProvider(object: MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        // Add menu items here
            menuInflater.inflate(R.menu.menu_fragment1, menu)
        }
        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // Handle the menu selection
            return when (menuItem.itemId) {
                R.id.saludo -> {
                    Toast.makeText(context, "Hola", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }
    },viewLifecycleOwner, Lifecycle.State.RESUMED)*/



    /*override fun onPrepareMenu(menu: Menu) {
        super.onPrepareMenu(menu)
        menu.findItem(R.id.miHola)?.isVisible=false
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}