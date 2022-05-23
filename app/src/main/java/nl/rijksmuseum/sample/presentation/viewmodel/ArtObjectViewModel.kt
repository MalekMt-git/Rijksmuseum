package nl.rijksmuseum.sample.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase
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
            artObject.postValue(Resource.Error(e.message.toString()))
        }
    }
}