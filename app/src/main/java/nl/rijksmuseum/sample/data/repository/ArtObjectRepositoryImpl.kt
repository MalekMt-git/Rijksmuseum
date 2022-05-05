package nl.rijksmuseum.sample.data.repository

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.model.headline.ArtObject
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository
import retrofit2.Response

class ArtObjectRepositoryImpl(
    private val artObjectRemoteDataSource: ArtObjectRemoteDataSource
) : ArtObjectRepository {
    override suspend fun getArtObjects(
        language: String,
        pageRange: Int,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            artObjectRemoteDataSource.getArtObjects(
                language = language,
                pageRange = pageRange,
                page = page
            )
        )
    }

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedArtObject(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtObjectDetails(
        objectId: String,
        language: String
    ): Resource<DetailsAPIResponse> {
        return responseToResource(
            artObjectRemoteDataSource.getArtObjectDetails(
                language = language,
                objectId = objectId
            )
        )
    }

    override suspend fun saveArtObject(artObject: ArtObject) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSavedArtObject(artObject: ArtObject) {
        TODO("Not yet implemented")
    }

    override fun getSavedArtObjects(): Flow<List<ArtObject>> {
        TODO("Not yet implemented")
    }
}