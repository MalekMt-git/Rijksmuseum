package nl.rijksmuseum.sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import com.example.domain.usecase.GetArtObjectUseCase

class ArtObjectViewModel(
    private val getArtObjectUseCase: GetArtObjectUseCase
) : ViewModel() {
    fun getArtObjects(defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery)
    = getArtObjectUseCase.execute(defaultArtObjectHeadlinesQuery, viewModelScope)
}