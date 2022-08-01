package nl.rijksmuseum.sample.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.common_architecture.util.Resource
import com.example.domain.model.query.ArtObjectDetailsQuery
import kotlinx.coroutines.launch

import nl.rijksmuseum.sample.databinding.FragmentDetailsBinding
import nl.rijksmuseum.sample.presentation.MainActivity
import nl.rijksmuseum.sample.presentation.adapter.DetailsAdapter
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModel

class DetailsFragment : Fragment() {
    private lateinit var viewModel : DetailsViewModel
    private lateinit var artObjectDetailsQuery: ArtObjectDetailsQuery
    private val binding : FragmentDetailsBinding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= (activity as MainActivity).detailsViewModel
        val args : DetailsFragmentArgs by navArgs()
        artObjectDetailsQuery = args.artObjectDetailsQueryImpl
        binding.saveBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "isChecked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "is Not Checked", Toast.LENGTH_SHORT).show()
            }
        }
        viewArtObjectDetails()
    }

    private fun viewArtObjectDetails(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getArtObjectDetails(artObjectDetailsQuery).observe(viewLifecycleOwner) { resource ->
                    when(resource){
                        is Resource.Success ->{
                            resource.data?.let {
                                DetailsAdapter(it).bind(binding)
                            }
                        }
                        is Resource.Error ->{ resource.message?.let { Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show() } }
                        is Resource.Loading ->{
                        }
                    }
                }
            }
        }
    }
}
