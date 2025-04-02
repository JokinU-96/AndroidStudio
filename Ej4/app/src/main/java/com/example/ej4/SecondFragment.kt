package com.example.ej4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
                    if (edad > 18) {
                        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                        var usuarioActual = Usuario(binding.etNombre.text.toString(), binding.etApellidos.text.toString(), edad)
                        (activity as MainActivity).usuario = usuarioActual

                    } else {
                        Toast.makeText(context, "Debes ser mayor de edad para poder comprarte un coche en este concesionario.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } catch (e : NumberFormatException){
                Toast.makeText(context, "Por favor ingresa una edad válida", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}