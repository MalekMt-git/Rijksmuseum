package com.example.data.repository.dataSource

import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.headline.APIResponse
import retrofit2.Response

interface ArtObjectRemoteDataSource {
    suspend fun getArtObjects(
        language: String,
        pageRange: Int,
        page: Int
    ): Response<out APIResponse>

    suspend fun getArtObjectDetails(
        objectId: String,
        language: String
    ): Response< out DetailsAPIResponse>
}