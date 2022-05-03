package nl.rijksmuseum.sample.presentation.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nl.rijksmuseum.sample.MainActivity
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.databinding.ArtObjectListItemBinding
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel

class ArtObjectAdapter: RecyclerView.Adapter<ArtObjectAdapter.ArtObjectViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ArtObject>(){

        override fun areItemsTheSame(oldItem: ArtObject, newItem: ArtObject): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ArtObject, newItem: ArtObject): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    inner class ArtObjectViewHolder(
        private val binding: ArtObjectListItemBinding
        ): RecyclerView.ViewHolder(binding.root){
        fun bind(artObject: ArtObject) {
            binding.artistName.text = artObject.principalOrFirstMaker
            binding.artName.text = artObject.title

            Glide.with(binding.mainArtPicture.context)
                .load(artObject.webImage.url)
                .into(binding.mainArtPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtObjectViewHolder {
        val binding = ArtObjectListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtObjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtObjectViewHolder, position: Int) {
        val artObject = differ.currentList[position]
        holder.bind(artObject)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}