package com.example.ej4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.MenuHost
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
            findNavController().navigate(R.id.action_FirstFragment_to_ThirdFragment)
        }

        if((activity as MainActivity).usuario != null){
            binding.saludo.text = (activity as MainActivity).usuario?.nombre
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}