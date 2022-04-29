package nl.rijksmuseum.sample.data.api

import nl.rijksmuseum.sample.BuildConfig
import nl.rijksmuseum.sample.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionAPIService {

    @GET("/api/{culture}/collection")
    suspend fun getTopCollections(
    @Path("culture") language: String,
    @Query("key") key: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}
