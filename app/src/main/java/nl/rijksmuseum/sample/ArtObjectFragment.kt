package nl.rijksmuseum.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.databinding.FragmentArtObjectBinding
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectAdapter
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel

class ArtObjectFragment : Fragment() {
    private lateinit var viewModel: ArtObjectViewModel
    private lateinit var artObjectAdapter: ArtObjectAdapter
    private lateinit var fragmentArtObjectBinding:FragmentArtObjectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_art_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentArtObjectBinding = FragmentArtObjectBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        artObjectAdapter = (activity as MainActivity).artObjectAdapter
        initRecyclerView()
        viewArtObjectList()
    }

    private fun viewArtObjectList() {
        viewModel.getArtObjects()
        viewModel.artObject.observe(viewLifecycleOwner) { response ->
            when(response){
                is Resource.Success ->{
                    hidProgressBar()
                    response.data?.let {
                        artObjectAdapter.differ.submitList(it.artObjects.toList())
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
        //artObjectAdapter = ArtObjectAdapter()
        fragmentArtObjectBinding.rvArtObject.apply {
            adapter = artObjectAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun showProgressBar(){
        fragmentArtObjectBinding.progressBar.visibility = View.VISIBLE
    }
    private fun hidProgressBar(){
        fragmentArtObjectBinding.progressBar.visibility = View.INVISIBLE
    }
}