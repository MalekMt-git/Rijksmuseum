package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectDetailsUseCase
import nl.rijksmuseum.sample.presentation.util.isNetworkAvailable

class DetailsViewModel(
    private val app: Application,
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
    ): AndroidViewModel(app) {
    val artObjectDetails: MutableLiveData<Resource<DetailsAPIResponse>> = MutableLiveData(Resource.Loading())
    suspend fun getArtObjectDetails(objectId: String, language: String) =
            try {
                if (isNetworkAvailable(app)){
                    artObjectDetails.postValue(Resource.Loading())
                }
                val apiResult = getArtObjectDetailsUseCase.execute(objectId, language)
                artObjectDetails.postValue(apiResult)
            } catch (e:Exception){
                artObjectDetails.postValue(Resource.Error(e.message.toString()))
            }

}