package nl.rijksmuseum.sample.presentation.adapter


import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.databinding.FragmentDetailsBinding

class DetailsAdapter(detailsAPIResponse: DetailsAPIResponse) {
    private val detailsArtObject = detailsAPIResponse.detailsArtObject

    fun bind(binding: FragmentDetailsBinding){
        detailsArtObject.apply {
            binding.headerTitle.text = title
            binding.headerBody.text = description

            Glide.with(binding.mainArtPicture.context)
                .load(webImage.url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.linearProgressIndicator.visibility = android.view.View.GONE
                        binding.contentLayout.animate().alpha(1f).duration = 400
                        return false
                    }
                })
                .into(binding.mainArtPicture)
        }
    }
}