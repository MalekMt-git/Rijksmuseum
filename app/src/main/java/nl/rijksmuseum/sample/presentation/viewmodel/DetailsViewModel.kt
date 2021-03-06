package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.common_architecture.util.Resource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.usecase.GetArtObjectDetailsUseCase
import nl.rijksmuseum.sample.presentation.util.isNetworkAvailable

class DetailsViewModel(
    private val app: Application,
    private val getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase
    ): AndroidViewModel(app) {
    val artObjectDetails: MutableLiveData<Resource<DetailsAPIResponse>> = MutableLiveData(Resource.Loading())
    suspend fun getArtObjectDetails(artObjectDetailsQuery : ArtObjectDetailsQuery) =
            try {
                if (isNetworkAvailable(app)){
                    artObjectDetails.postValue(Resource.Loading())
                }
                val apiResult = getArtObjectDetailsUseCase.execute(artObjectDetailsQuery)
                artObjectDetails.postValue(apiResult)
            } catch (e:Exception){
                artObjectDetails.postValue(Resource.Error(e.message.toString()))
            }

}