package nl.rijksmuseum.sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.usecase.GetArtObjectDetailsUseCase
import kotlinx.coroutines.Dispatchers

class DetailsViewModel(private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase): ViewModel() {
    fun getArtObjectDetails(query: ArtObjectDetailsQuery) = liveData(Dispatchers.IO){ emit(getArtObjectDetailsUseCase.getDetails(query))}
    fun getArtObjectImages(query: ArtObjectDetailsQuery) = liveData(Dispatchers.IO){ emit(getArtObjectDetailsUseCase.getImages(query))}
}