package com.example.recycled_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycled_view.databinding.FragmentFirstBinding
import com.example.recycled_view.recyclerView.Adaptador

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var usuarios : MutableList<String> = mutableListOf("Jokin", "Claudia", "Egoi", "Maria", "Mario")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ffrvUsuarios.layoutManager= LinearLayoutManager(context)
        binding.ffrvUsuarios.adapter= Adaptador(usuarios)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}