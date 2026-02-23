package com.example.peretz.core.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.peretz.R
import com.example.peretz.core.presentation.navigation.Screens
import com.example.peretz.databinding.FragmentSaleBinding
import com.jamal_aliev.navigationcontroller.navigator.NavigationControllerHolder
import me.aartikov.alligator.Navigator
import me.aartikov.alligator.ScreenResolver
import org.koin.android.ext.android.get

class SaleFragment : Fragment(R.layout.fragment_sale) {

    private var _binding: FragmentSaleBinding? = null
    private val binding get() = _binding!!

    lateinit var saleImage: ImageView

    private val navigator: Navigator = NavigationControllerHolder.requireNavigator()
    private val screenResolver: ScreenResolver = ScreenResolver(get())
    private val args: Screens.Sale by lazy { screenResolver.getScreen(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSaleBinding.bind(view)

        saleImage = view.findViewById(R.id.item_sale_image)
        saleImage.adjustViewBounds = false
        saleImage.scaleType = ImageView.ScaleType.CENTER_CROP
        when (args.id) {
            "roll" -> saleImage.setImageResource(R.drawable.img_roll)
            "pizza" -> saleImage.setImageResource(R.drawable.img_pizza)
        }

        binding.saleTopbarBackButton.setOnClickListener {
            navigator.goBack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}