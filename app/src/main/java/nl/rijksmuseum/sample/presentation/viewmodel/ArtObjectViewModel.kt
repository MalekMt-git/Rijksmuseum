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
import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase

class ArtObjectViewModel(
    private val app:Application,
    private val getArtObjectUseCase: GetArtObjectUseCase
) : AndroidViewModel(app) {
    val artObject : MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun getArtObjects(language : String = "en",
                      pageRange: Int = 100,
                      page : Int = 1) = viewModelScope.launch(Dispatchers.IO){
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

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}