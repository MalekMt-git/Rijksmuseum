package nl.rijksmuseum.sample.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.model.headline.ArtObject
import nl.rijksmuseum.sample.databinding.ArtObjectListItemBinding

class ArtObjectsPagingAdapter: PagingDataAdapter<ArtObject,ArtObjectsPagingAdapter.ArtObjectViewHolder>(diffUtil){
    private var onItemClickListener :((ArtObject)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtObjectViewHolder {
        val binding = ArtObjectListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtObjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtObjectViewHolder, position: Int) {
        getItem(position).let { if (it != null) holder.bind(it) }
    }

    inner class ArtObjectViewHolder(
        private val binding: ArtObjectListItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(artObject: ArtObject) {
            binding.artistName.text = artObject.principalOrFirstMaker
            binding.artName.text = artObject.title
            Glide.with(binding.mainArtPicture.context)
                .load(artObject.webImage.url)
                .into(binding.mainArtPicture)
            binding.root.setOnClickListener{ onItemClickListener?.let { it(artObject) } }
        }
    }

    fun setOnClickListener(listener:(ArtObject)->Unit){ onItemClickListener = listener }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ArtObject>() {
            override fun areItemsTheSame(oldItem: ArtObject, newItem: ArtObject) = oldItem.id == newItem.id
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: ArtObject, newItem: ArtObject) = oldItem == newItem
        }
    }
}