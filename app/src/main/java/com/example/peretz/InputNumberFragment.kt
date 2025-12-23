package com.example.peretz

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.peretz.core.presentation.navigation.Screens
import com.example.peretz.databinding.FragmentInputNumberBinding
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import com.santalu.maskara.Mask
import com.santalu.maskara.MaskChangedListener
import com.santalu.maskara.MaskStyle
import me.aartikov.alligator.Navigator

class InputNumberFragment : Fragment(R.layout.fragment_input_number) {

    private var _binding: FragmentInputNumberBinding? = null
    private val binding get() = _binding!!
    private val navigator: Navigator = NavigationControllerHolder.requireNavigator()

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

        binding.proceedOtpButton.isEnabled = false

        binding.proceedOtpButton.setOnClickListener {
            val currentPhoneNumber = binding.numberInputEditText.text.toString()
            onNextInputButtonClicked(currentPhoneNumber)
        }

        val mask = Mask(
            value = "+7 (___) ___-__-__",
            character = '_',
            style = MaskStyle.COMPLETABLE
        )
        val listener = MaskChangedListener(mask)
        binding.numberInputEditText.addTextChangedListener(listener)

        binding.numberInputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val isFull = s?.length == 18
                binding.proceedOtpButton.isEnabled = isFull
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun showRandomDigitsToast() {
        val randomDigits = List(6) { (0..9).random() }.joinToString("")
        val formattedMessage = "${randomDigits.substring(0, 2)}-${
            randomDigits.substring(
                2,
                4
            )
        }-${randomDigits.substring(4, 6)}"

        Toast.makeText(context, formattedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun onNextInputButtonClicked(phoneNumber: String) {
        showRandomDigitsToast()
        navigator.goForward(Screens.Otp(phoneNumber))
    }

}
