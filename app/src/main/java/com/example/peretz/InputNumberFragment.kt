package com.example.peretz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.peretz.databinding.FragmentInputNumberBinding

class InputNumberFragment : Fragment(R.layout.fragment_input_number) {

    private var _binding: FragmentInputNumberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentInputNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInputNumberBinding.bind(view)
    }

    private fun onNextInputButtonClicked(phoneNumber: String) {
    }

    override fun onDestroyView() {

    }
}