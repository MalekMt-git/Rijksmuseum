package nl.rijksmuseum.sample.data.repository.dataSource

import nl.rijksmuseum.sample.data.model.headline.APIResponse
import retrofit2.Response

interface ArtObjectRemoteDataSource {
    suspend fun getTopArtObject(language : String,
                                pageRange: Int,
                                page : Int):Response<APIResponse>
}
