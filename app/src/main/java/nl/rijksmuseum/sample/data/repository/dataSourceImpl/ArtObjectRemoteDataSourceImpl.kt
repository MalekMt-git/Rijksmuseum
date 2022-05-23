package nl.rijksmuseum.sample.data.repository.dataSourceImpl

import nl.rijksmuseum.sample.data.api.ArtObjectAPIService
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
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
