package tech.ericwathome.moments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.ericwathome.moments.databinding.FragmentImagesBinding

class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}