package nl.rijksmuseum.sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetArtObjectUseCase

class ArtObjectViewModelFactory(
    private val getArtObjectUseCase: GetArtObjectUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtObjectViewModel(getArtObjectUseCase) as T
    }
}