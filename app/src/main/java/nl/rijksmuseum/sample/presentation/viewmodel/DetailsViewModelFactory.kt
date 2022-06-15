package nl.rijksmuseum.sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetArtObjectDetailsUseCase

class DetailsViewModelFactory(
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(getArtObjectDetailsUseCase) as T
    }
}