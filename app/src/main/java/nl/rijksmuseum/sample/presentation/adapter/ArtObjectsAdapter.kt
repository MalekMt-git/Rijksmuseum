package nl.rijksmuseum.sample.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.headline.ArtObject
import nl.rijksmuseum.sample.databinding.ArtObjectListItemBinding

class ArtObjectsAdapter: RecyclerView.Adapter<ArtObjectsAdapter.ArtObjectViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ArtObject>(){

        override fun areItemsTheSame(oldItem: ArtObject, newItem: ArtObject): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
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

            binding.root.setOnClickListener{
                onItemClickListener?.let {
                    it(artObject)
                }
            }
        }
    }

    private var onItemClickListener :((ArtObject)->Unit)?=null

    fun setOnClickListener(listener:(ArtObject)->Unit){
        onItemClickListener=listener
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
