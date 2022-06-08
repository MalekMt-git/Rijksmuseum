package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetArtObjectDetailsUseCase

class DetailsViewModelFactory(
    private val app:Application,
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(app, getArtObjectDetailsUseCase) as T
    }
}