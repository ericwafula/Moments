package tech.ericwathome.moments.adapters

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tech.ericwathome.moments.databinding.ImageListItemBinding
import tech.ericwathome.moments.model.Image

class ImageAdapter (private val context: Context, private val images: List<Image>):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    companion object {
        private val TAG = this::class.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ImageListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.setData(image)
    }

    override fun getItemCount() = images.size

    inner class ViewHolder(private val binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(image: Image) {
            image.size?.regular.let {
                Glide.with(context)
                    .load(it)
                    .into(binding.imvTrending)
            }
        }

    }
}