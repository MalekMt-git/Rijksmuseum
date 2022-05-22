package nl.rijksmuseum.sample.presentation.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import nl.rijksmuseum.sample.R
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.databinding.FragmentDetailsBinding
import nl.rijksmuseum.sample.presentation.MainActivity
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModel

class DetailsFragment : Fragment() {
    private lateinit var viewModel : DetailsViewModel
    private lateinit var objectId : String
    private lateinit var language : String
    private lateinit var binding: FragmentDetailsBinding
    private var isLoading = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        viewModel= (activity as MainActivity).detailsViewModel
        val args : DetailsFragmentArgs by navArgs()
        objectId = args.objectId
        language = args.language

        showProgressBar()
        viewArtObjectDetails()
    }

    private fun viewArtObjectDetails(){
        showProgressBar()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getArtObjectDetails(objectId, language)
                viewModel.artObjectDetails.observe(viewLifecycleOwner) { resource ->
                    when(resource){
                        is Resource.Success ->{
                            resource.data?.let {
                                binding.headerTitle.text = it.artObject.title
                                binding.headerBody.text = it.artObject.description

                                Glide.with(binding.mainArtPicture.context)
                                    .load(it.artObject.webImage.url)
                                    .listener(object : RequestListener<Drawable>{
                                        override fun onLoadFailed(
                                            e: GlideException?,
                                            model: Any?,
                                            target: Target<Drawable>?,
                                            isFirstResource: Boolean
                                        ): Boolean {
                                            hidProgressBar()
                                            return false
                                        }

                                        override fun onResourceReady(
                                            resource: Drawable?,
                                            model: Any?,
                                            target: Target<Drawable>?,
                                            dataSource: DataSource?,
                                            isFirstResource: Boolean
                                        ): Boolean {
                                            hidProgressBar()
                                            return false
                                        }

                                    })
                                    .into(binding.mainArtPicture)

                                binding.root.setOnClickListener{

                                }
                            }
                        }
                        is Resource.Error ->{
                            hidProgressBar()
                            resource.message?.let {
                                Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                            }
                        }
                        is Resource.Loading ->{
                            showProgressBar()
                        }
                    }
                }
            }
        }

    }

    private fun showProgressBar(){
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
        binding.headerTitle.visibility = View.INVISIBLE
        binding.headerBody.visibility = View.INVISIBLE
        binding.mainArtPicture.visibility = View.INVISIBLE
    }
    private fun hidProgressBar(){
        isLoading = false
        binding.headerTitle.visibility = View.VISIBLE
        binding.headerBody.visibility = View.VISIBLE
        binding.mainArtPicture.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }
}
