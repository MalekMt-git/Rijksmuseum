package nl.rijksmuseum.sample.presentation.fragment

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.model.headline.ArtObject
import com.example.data.model.query.ArtObjectDetailsQueryImpl
import com.example.data.model.query.ArtObjectHeadlinesQueryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nl.rijksmuseum.sample.R
import nl.rijksmuseum.sample.databinding.FragmentArtObjectsBinding
import nl.rijksmuseum.sample.databinding.FragmentSavedBinding
import nl.rijksmuseum.sample.presentation.MainActivity
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectsPagingAdapter
import nl.rijksmuseum.sample.presentation.util.isNetworkAvailable
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel

private const val PAGING_SIZE = 10

class ArtObjectsFragment : Fragment() {
    private lateinit var viewModel: ArtObjectViewModel
    private lateinit var artObjectsPagingAdapter: ArtObjectsPagingAdapter
    private val binding : FragmentArtObjectsBinding by lazy { FragmentArtObjectsBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= (activity as MainActivity).artObjectViewModel
        artObjectsPagingAdapter = (activity as MainActivity).artObjectsPagingAdapter
        artObjectsPagingAdapter.setOnClickListener { findNavController().navigate(ArtObjectsFragmentDirections.actionArtObjectFragmentToInfoFragment(ArtObjectDetailsQueryImpl(it.objectNumber , "en"))) }
        initRecyclerView()
        if (isNetworkAvailable(this.context)) viewArtObjectList()
    }

    private fun viewArtObjectList() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getArtObjects(ArtObjectHeadlinesQueryImpl("en" , PAGING_SIZE , 1 )) .collectLatest {
                    artObjectsPagingAdapter.submitData(it as PagingData<ArtObject>)
                }
            }
        }

//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                artObjectsPagingAdapter.loadStateFlow.collect {
//                    if (it.source.refresh is LoadState.Loading) {
//                        Log.i("ArtObjectsFragment", "LoadState: ${it.source}")
//                        binding.prependProgress.isVisible = it.source.prepend is LoadState.Loading
//                    }
//                }
//            }
//        }
    }

    private fun initRecyclerView() {
        binding.rvArtObject.apply {
            adapter = artObjectsPagingAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
