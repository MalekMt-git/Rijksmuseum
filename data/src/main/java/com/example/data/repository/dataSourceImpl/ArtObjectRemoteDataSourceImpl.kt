package com.example.data.repository.dataSourceImpl

import com.example.data.api.ArtObjectAPIService
import com.example.data.repository.dataSource.ArtObjectRemoteDataSource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.headline.APIResponse
import retrofit2.Response

class ArtObjectRemoteDataSourceImpl(
    private val artObjectAPIService: ArtObjectAPIService,
    ): ArtObjectRemoteDataSource {
    override suspend fun getArtObjects(language : String,
                                       pageRange: Int,
                                       page : Int): Response<out APIResponse> {
        return artObjectAPIService.getArtObjects(language = language,
            pageRange = pageRange,
            page = page)
    }

    override suspend fun getArtObjectDetails(
        objectId: String,
        language: String
    ): Response<out DetailsAPIResponse> {
        return artObjectAPIService.getArtObjectDetails(language, objectId)
    }
}
