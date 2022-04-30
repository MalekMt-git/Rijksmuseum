package nl.rijksmuseum.sample.data.repository.dataSourceImpl

import nl.rijksmuseum.sample.data.api.ArtObjectAPIService
import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
import retrofit2.Response

class ArtObjectRemoteDataSourceImpl(
    private val artObjectAPIService: ArtObjectAPIService,
    ): ArtObjectRemoteDataSource {
    override suspend fun getTopArtObject(language : String): Response<APIResponse> {
        return artObjectAPIService.getTopArtObject(language)
    }
}
