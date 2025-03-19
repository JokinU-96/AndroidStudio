package com.example.ej4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import com.example.ej4.databinding.FragmentThirdBinding


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

        //Recorre la lista de vehiculos que hay en la actividad y agrega un checkbox programáticamente.
        for ((indice, elemento) in (activity as MainActivity).vehiculos.withIndex()){
            //Crea un nuevo CheckBox. Necesita como parametro un contexto. Para ello usamos context
            val checkBox = CheckBox(context)
            checkBox.text = elemento.marcaVehiculo
            //Establece el id del CheckBox, que va a coincidir con la posición del vehiculo en la lista.
            checkBox.id = indice
            //Agrega el CheckBox al LinearLayout
            binding.llVehiculos.addView(checkBox)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}