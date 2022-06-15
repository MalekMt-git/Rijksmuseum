package com.example.data.api


import com.example.data.BuildConfig
import com.example.data.model.detail.DetailsAPIResponseImpl
import com.example.data.model.headline.APIResponseImpl
import com.example.data.model.image.Image
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
    ): Response<APIResponseImpl>

    @GET("/api/{culture}/collection/{objectId}")
    suspend fun getArtObjectDetails(
        @Path("culture") language: String,
        @Path("objectId") objectId: String,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Response<DetailsAPIResponseImpl>

    @GET("/api/{culture}/collection/{objectId}/tiles")
    suspend fun getArtObjectImages(
        @Path("culture") language: String,
        @Path("objectId") objectId: String,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Response<Image>
}
