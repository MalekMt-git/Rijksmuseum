package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common_architecture.util.Resource
import com.example.domain.model.headline.APIResponse
import com.example.domain.usecase.GetArtObjectUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nl.rijksmuseum.sample.presentation.util.isNetworkAvailable

class ArtObjectViewModel(
    private val app:Application,
    private val getArtObjectUseCase: GetArtObjectUseCase
) : AndroidViewModel(app) {
    val artObject : MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun getArtObjects(language : String,
                      pageRange: Int,
                      page : Int) = viewModelScope.launch(Dispatchers.IO){
        try {
            if (isNetworkAvailable(app)){
                artObject.postValue(Resource.Loading())
            }
            val apiResult = getArtObjectUseCase.execute(language=language,
                pageRange=pageRange,
                page=page)
            artObject.postValue(apiResult)
        } catch (e:Exception){
            throw e
            artObject.postValue(Resource.Error(e.message.toString()))
        }
    }
}