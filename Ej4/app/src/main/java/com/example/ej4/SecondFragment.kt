package com.example.ej4

import android.content.Context
import android.content.SharedPreferences
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
import com.example.ej4.databinding.FragmentSecondBinding
import com.example.ej4.modelo.Usuario


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        val datos: SharedPreferences=(activity as MainActivity).getSharedPreferences("datos",Context.MODE_PRIVATE)
        val editor = datos.edit()

        binding.etNombre.setText((activity as MainActivity).miViewModel.usuario?.nombre.toString())
        binding.etApellidos.setText((activity as MainActivity).miViewModel.usuario?.apellidos.toString())
        binding.etEdad.setText((activity as MainActivity).miViewModel.usuario?.edad.toString())

        binding.btnInsertar.setOnClickListener{
            try {
                if (binding.etNombre.text.isNullOrEmpty()) {
                    Toast.makeText(context, "Por favor introduzca su nombre.", Toast.LENGTH_SHORT)
                        .show()
                } else if (binding.etApellidos.text.isNullOrEmpty()) {
                    Toast.makeText(
                        context,
                        "Por favor introduzca sus apellidos.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (binding.etEdad.text.isNullOrEmpty()) {
                    Toast.makeText(context, "Por favor introduzca su edad.", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val edadText = binding.etEdad.text.toString()
                    val edad = edadText.toInt()
                    if (edad >= 16) {
                        var usuarioActual = Usuario(binding.etNombre.text.toString(), binding.etApellidos.text.toString(), edad)

                        (activity as MainActivity).miViewModel.usuario = usuarioActual

                        editor.putInt("edad", edad)
                        editor.putString("nombre", binding.etNombre.text.toString())
                        editor.putString("apellidos", binding.etApellidos.text.toString())
                        editor.apply()

                        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

                    } else {
                        Toast.makeText(context, "Debes ser mayor de edad para poder comprarte un coche en este concesionario.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } catch (e : NumberFormatException){
                Toast.makeText(context, "Por favor ingresa una edad válida", Toast.LENGTH_SHORT).show()
            }
        }

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater){
                menuInflater.inflate(R.menu.menu_fragment2, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.insertar -> {
                        insertarLogIn()
                        true
                    }
                    else -> false // Return false for unhandled items, allowing other MenuProviders to handle them
                }
                return true
            }

            private fun insertarLogIn() {
                try {
                    if (binding.etNombre.text.isNullOrEmpty()) {
                        Toast.makeText(context, "Por favor introduzca su nombre.", Toast.LENGTH_SHORT)
                            .show()
                    } else if (binding.etApellidos.text.isNullOrEmpty()) {
                        Toast.makeText(
                            context,
                            "Por favor introduzca sus apellidos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (binding.etEdad.text.isNullOrEmpty()) {
                        Toast.makeText(context, "Por favor introduzca su edad.", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        val edadText = binding.etEdad.text.toString()
                        val edad = edadText.toInt()
                        if (edad >= 16) {
                            var usuarioActual = Usuario(binding.etNombre.text.toString(), binding.etApellidos.text.toString(), edad)

                            (activity as MainActivity).miViewModel.usuario = usuarioActual

                            editor.putInt("edad", edad)
                            editor.putString("nombre", binding.etNombre.text.toString())
                            editor.putString("apellidos", binding.etApellidos.text.toString())
                            editor.apply()

                            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

                        } else {
                            Toast.makeText(context, "Debes ser mayor de edad para poder comprarte un coche en este concesionario.", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } catch (e : NumberFormatException){
                    Toast.makeText(context, "Por favor ingresa una edad válida", Toast.LENGTH_SHORT).show()
                }
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}