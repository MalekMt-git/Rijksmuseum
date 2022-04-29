package nl.rijksmuseum.sample.data.repository

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.data.repository.dataSource.RemoteCollectionDataSource
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.CollectionRepository
import retrofit2.Response

class CollectionRepositoryImpl(private val remoteCollectionDataSource: RemoteCollectionDataSource
) : CollectionRepository{
    override suspend fun getCollectionHeadlines(): Resource<APIResponse> {
        return responseToResource(remoteCollectionDataSource.getTopCollections())
    }

    private fun responseToResource(response:Response<APIResponse>) :Resource<APIResponse>{
        if (response.isSuccessful){
            response.body()?.let {result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedCollection(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveCollection(article: ArtObject) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSavedCollection(article: ArtObject) {
        TODO("Not yet implemented")
    }

    override fun getSavedCollection(): Flow<List<ArtObject>> {
        TODO("Not yet implemented")
    }
}