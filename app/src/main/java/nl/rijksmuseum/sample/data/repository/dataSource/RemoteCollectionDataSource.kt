package nl.rijksmuseum.sample.data.repository.dataSource

import nl.rijksmuseum.sample.data.model.APIResponse
import retrofit2.Response

interface RemoteCollectionDataSource {
    suspend fun getTopCollections():Response<APIResponse>
}
