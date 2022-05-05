package nl.rijksmuseum.sample.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nl.rijksmuseum.sample.presentation.MainActivity
import nl.rijksmuseum.sample.R
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.databinding.FragmentArtObjectsBinding
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectsAdapter
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel

class ArtObjectsFragment : Fragment() {
    private lateinit var viewModel: ArtObjectViewModel
    private lateinit var artObjectsAdapter: ArtObjectsAdapter
    private lateinit var fragmentArtObjectsBinding: FragmentArtObjectsBinding
    private val language = "en"
    private var pageRange = 10
    private var page = 1
    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false
    private var pages = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_art_objects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArtObjectsBinding = FragmentArtObjectsBinding.bind(view)
        viewModel= (activity as MainActivity).artObjectViewModel
        artObjectsAdapter = (activity as MainActivity).artObjectsAdapter
        artObjectsAdapter.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("objectId", it.objectNumber)
                putSerializable("language", language)
            }
            findNavController().navigate(
                R.id.action_artObjectFragment_to_infoFragment,
                bundle
            )
        }
        initRecyclerView()
        viewArtObjectList()
    }

    private fun viewArtObjectList() {
        viewModel.getArtObjects(language, pageRange, page)
        viewModel.artObject.observe(viewLifecycleOwner) { response ->
            when(response){
                is Resource.Success ->{
                    hidProgressBar()
                    response.data?.let {
                        artObjectsAdapter.differ.submitList(it.artObjects.toList())
                        pages = if (it.count % 20 == 0){
                            it.count / 20
                        }else{
                            it.count / 20 + 1
                        }
                        isLastPage = page == pages
                    }
                }
                is Resource.Error ->{
                    hidProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading ->{
                    showProgressBar()
                }
            }
        }
    }
    private fun initRecyclerView() {
        fragmentArtObjectsBinding.rvArtObject.apply {
            adapter = artObjectsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@ArtObjectsFragment.onScrollListener)
        }
    }
    private fun showProgressBar(){
        isLoading = true
        fragmentArtObjectsBinding.progressBar.visibility = View.VISIBLE
    }
    private fun hidProgressBar(){
        isLoading = false
        fragmentArtObjectsBinding.progressBar.visibility = View.GONE
    }

    private val onScrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = fragmentArtObjectsBinding.rvArtObject.layoutManager as LinearLayoutManager
            val sizeOfCurrentList = layoutManager.itemCount
            val visibleItems = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()
            val hasReachedToEnd = topPosition + visibleItems >= sizeOfCurrentList
            val shouldPaginate = !isLoading && !isLastPage && hasReachedToEnd && isScrolling
            if (shouldPaginate){
                pageRange += 10
                if (pageRange >= 100){
                    pageRange = 10
                    page ++
                }
                viewModel.getArtObjects(language, pageRange, page)
            }
        }
    }
}