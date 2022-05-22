package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectDetailsUseCase
import nl.rijksmuseum.sample.presentation.util.isNetworkAvailable

class DetailsViewModel(
    private val app: Application,
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
    ): AndroidViewModel(app) {
    private val artObjectDetails: MutableStateFlow<Resource<DetailsAPIResponse>> = MutableStateFlow(Resource.Loading())
    val uiState: StateFlow<Resource<DetailsAPIResponse>> = artObjectDetails
    fun getArtObjectDetails(objectId: String, language: String) =
         viewModelScope.launch(Dispatchers.IO)
        {
            try {
                if (isNetworkAvailable(app)){
                    artObjectDetails.value = Resource.Loading()
                }
                val apiResult = getArtObjectDetailsUseCase.execute(objectId, language)
                artObjectDetails.value = apiResult
            } catch (e:Exception){
                artObjectDetails.value = Resource.Error(e.message.toString())
            }
        }
}