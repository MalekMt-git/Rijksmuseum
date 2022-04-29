package nl.rijksmuseum.sample.data.repository.dataSourceImpl

import nl.rijksmuseum.sample.data.api.CollectionAPIService
import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.repository.dataSource.RemoteCollectionDataSource
import retrofit2.Response

class RemoteCollectionDataSourceImpl(
    private val collectionAPIService: CollectionAPIService,
    private val language: String
    ): RemoteCollectionDataSource {
    override suspend fun getTopCollections(): Response<APIResponse> {
        return collectionAPIService.getTopCollections(language)
    }
}
