package com.example.introabbdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.introabbdd.databinding.FragmentFirstBinding
import com.example.introabbdd.databinding.FragmentListadoBinding
import com.example.introabbdd.recyclerView.Adaptador

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class listadoFragment : Fragment() {

    private var _binding: FragmentListadoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Aquí va la lógica
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).miViewModel.mostrarPeliculas()
        (activity as MainActivity).miViewModel.listaPeliculas.observe(activity as MainActivity){
            binding.lfrvPeliculas.layoutManager = LinearLayoutManager(context)
            binding.lfrvPeliculas.adapter=Adaptador(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}