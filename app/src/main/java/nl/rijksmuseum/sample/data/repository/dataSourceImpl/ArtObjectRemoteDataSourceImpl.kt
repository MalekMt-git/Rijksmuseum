package nl.rijksmuseum.sample.data.repository.dataSourceImpl

import nl.rijksmuseum.sample.data.api.ArtObjectAPIService
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
import retrofit2.Response

class ArtObjectRemoteDataSourceImpl(
    private val artObjectAPIService: ArtObjectAPIService,
    ): ArtObjectRemoteDataSource {
    override suspend fun getTopArtObject(language : String,
                                         pageRange: Int,
                                         page : Int): Response<APIResponse> {
        return artObjectAPIService.getTopArtObject(language = language,
            pageRange = pageRange,
            page = page)
    }
}
