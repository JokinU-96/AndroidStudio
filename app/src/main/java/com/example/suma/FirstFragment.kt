package com.example.suma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.suma.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    var contador:Int = 0

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

        binding.contador1.setText((activity as MainActivity).miViewModel.contador.toString())
        binding.contador2.setText((activity as MainActivity).miViewModel.contador.toString())

        binding.btnSumar.setOnClickListener{
            contador++
            (activity as MainActivity).miViewModel.contador++
            binding.contador2.setText((activity as MainActivity).miViewModel.contador.toString())
            binding.contador1.setText((activity as MainActivity).miViewModel.contador.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}