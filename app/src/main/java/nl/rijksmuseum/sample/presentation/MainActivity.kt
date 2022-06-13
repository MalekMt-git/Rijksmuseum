package nl.rijksmuseum.sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import nl.rijksmuseum.sample.R
import nl.rijksmuseum.sample.databinding.ActivityMainBinding
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectsPagingAdapter
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModelFactory
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModel
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var artObjectViewModelFactory: ArtObjectViewModelFactory
    @Inject lateinit var detailsViewModelFactory: DetailsViewModelFactory
    lateinit var artObjectViewModel: ArtObjectViewModel
    lateinit var detailsViewModel: DetailsViewModel
    @Inject lateinit var artObjectsPagingAdapter: ArtObjectsPagingAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvArtObject.setupWithNavController(navController)
        artObjectViewModel = ViewModelProvider(this,artObjectViewModelFactory)[ArtObjectViewModel::class.java]
        detailsViewModel = ViewModelProvider(this,detailsViewModelFactory)[DetailsViewModel::class.java]
    }
}