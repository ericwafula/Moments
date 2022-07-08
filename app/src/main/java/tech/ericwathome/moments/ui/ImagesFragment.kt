package tech.ericwathome.moments.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tech.ericwathome.moments.adapters.ImageAdapter
import tech.ericwathome.moments.databinding.FragmentImagesBinding
import tech.ericwathome.moments.model.ImagesFragmentViewModel

class ImagesFragment : Fragment() {
    companion object {
        private val TAG = this::class.simpleName
    }

    private lateinit var binding: FragmentImagesBinding
    private val viewModel: ImagesFragmentViewModel by viewModels()
    private lateinit var adapter: ImageAdapter

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

        initViews()

        return binding.root
    }

    private fun initViews() {
        val context = requireContext()
        if (!viewModel.isCreated) {
            viewModel.getAllPhotos()
            viewModel.isCreated = true
        }

        lifecycleScope.launchWhenStarted {
            viewModel.allImagesSate.collect {
                adapter = ImageAdapter(context, it)
                setUpRecyclerView()
            }
        }
    }

    private fun setUpRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = layoutManager
    }
}