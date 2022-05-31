package com.example.data.repository.dataSourceImpl

import com.example.data.api.ArtObjectAPIService
import com.example.data.model.detail.DetailsAPIResponse
import com.example.data.model.headline.APIResponse
import com.example.data.repository.dataSource.ArtObjectRemoteDataSource
import retrofit2.Response

class ArtObjectRemoteDataSourceImpl(
    private val artObjectAPIService: ArtObjectAPIService,
    ): ArtObjectRemoteDataSource {
    override suspend fun getArtObjects(language : String,
                                       pageRange: Int,
                                       page : Int): Response<APIResponse> {
        return artObjectAPIService.getArtObjects(language = language,
            pageRange = pageRange,
            page = page)
    }

    override suspend fun getArtObjectDetails(
        objectId: String,
        language: String
    ): Response<DetailsAPIResponse> {
        return artObjectAPIService.getArtObjectDetails(language, objectId)
    }
}
