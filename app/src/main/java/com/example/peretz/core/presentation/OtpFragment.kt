package com.example.peretz.core.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.peretz.R
import com.example.peretz.databinding.FragmentOtpBinding

class OtpFragment : Fragment(R.layout.fragment_otp) {

    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOtpBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}