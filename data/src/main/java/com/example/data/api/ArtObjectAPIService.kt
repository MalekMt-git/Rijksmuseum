package nl.rijksmuseum.sample.data.api

import nl.rijksmuseum.sample.BuildConfig
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtObjectAPIService {

    @GET("/api/{culture}/collection")
    suspend fun getArtObjects(
    @Path("culture") language: String,
    @Query("key") key: String = BuildConfig.API_KEY,
    @Query("ps") pageRange: Int,
    @Query("p") page: Int,
    ): Response<APIResponse>

    @GET("/api/{culture}/collection/{objectId}")
    suspend fun getArtObjectDetails(
        @Path("culture") language: String,
        @Path("objectId") objectId: String,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Response<DetailsAPIResponse>
}
