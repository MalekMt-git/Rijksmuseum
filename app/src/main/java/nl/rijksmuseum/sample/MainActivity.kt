package nl.rijksmuseum.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import nl.rijksmuseum.sample.databinding.ActivityMainBinding
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectAdapter
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModel
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtObjectViewModelFactory
    @Inject
    lateinit var artObjectAdapter: ArtObjectAdapter
    lateinit var viewModel: ArtObjectViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvArtObject.setupWithNavController(
            navController
        )
        viewModel = ViewModelProvider(this,factory)[ArtObjectViewModel::class.java]
    }
}