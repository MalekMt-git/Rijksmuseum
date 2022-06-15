package nl.rijksmuseum.sample.presentation.adapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import nl.rijksmuseum.sample.R
import com.example.data.model.image.Image
import nl.rijksmuseum.sample.databinding.ViewpagerItemBinding

class ViewPagerAdapter(private val image: Image) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val binding = ViewpagerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.setData(image.levels[position].tiles[3].url)
    }

    override fun getItemCount(): Int = image.levels.size

    inner class ViewPagerViewHolder(private val binding: ViewpagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(imageUrl: String) {
//            Glide.with(binding.mainArtPicture)
//                .load(imageUrl)
//                .error(R.drawable.ic_launcher_foreground)
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .into(binding.mainArtPicture)


            Glide.with(binding.mainArtPicture.context)
                .load(imageUrl.replace("http", "https"))
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(binding.root.context , e.toString(), Toast.LENGTH_LONG).show()
                        return false
                    }
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        //hidProgressBar()
                        return false
                    }

                })
                .into(binding.mainArtPicture)
        }
    }
}