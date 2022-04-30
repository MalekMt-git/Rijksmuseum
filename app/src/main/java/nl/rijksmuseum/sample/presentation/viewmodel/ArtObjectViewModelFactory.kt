package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase

class ArtObjectViewModelFactory(
    private val app: Application,
    private val getArtObjectUseCase: GetArtObjectUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }

}