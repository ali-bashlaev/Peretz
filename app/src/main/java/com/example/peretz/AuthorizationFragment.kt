package com.example.peretz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.peretz.databinding.FragmentOtpBinding

class AuthorizationFragment : Fragment(R.layout.fragment_input_number) {

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