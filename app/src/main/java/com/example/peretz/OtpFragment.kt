package com.example.peretz

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.peretz.databinding.FragmentOtpBinding
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import com.santalu.maskara.Mask
import com.santalu.maskara.MaskChangedListener
import com.santalu.maskara.MaskStyle
import me.aartikov.alligator.Navigator

class OtpFragment : Fragment(R.layout.fragment_otp) {

    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!
    private val fragmentNavigator: Navigator = NavigationControllerHolder.requireNavigator()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOtpBinding.bind(view)

        val mask = Mask(
            value = "__-__-__",
            character = '_',
            style = MaskStyle.COMPLETABLE
        )
        val listener = MaskChangedListener(mask)
        binding.otpEditText.addTextChangedListener(listener)

        binding.otpEditText.doAfterTextChanged { editable: Editable? ->
            binding.proceedOtpButton.isEnabled = editable?.length == 6
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
