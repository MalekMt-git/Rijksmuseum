package nl.rijksmuseum.sample.data.repository.dataSource

import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import retrofit2.Response

interface ArtObjectRemoteDataSource {
    suspend fun getArtObjects(
        language: String,
        pageRange: Int,
        page: Int
    ): Response<APIResponse>

    suspend fun getArtObjectDetails(
        objectId: String,
        language: String
    ): Response<DetailsAPIResponse>
}