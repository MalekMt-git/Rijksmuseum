package com.example.data.repository


import com.example.data.model.headline.APIResponse
import com.example.data.repository.dataSource.ArtObjectRemoteDataSource
import com.example.data.util.Resource
import com.example.domain.repository.ArtObjectRepository
import retrofit2.Response

class ArtObjectRepositoryImpl(
    private val artObjectRemoteDataSource: ArtObjectRemoteDataSource
) : ArtObjectRepository {

    override suspend fun <Resource> getArtObjects(
        language: String,
        pageRange: Int,
        page: Int
    ): resource {
        return responseToResource(
            artObjectRemoteDataSource.getArtObjects(
                language = language,
                pageRange = pageRange,
                page = page
            )
        )
    }

//    override suspend fun <Resource : Resource<APIResponse>> getArtObjects(
//        language: String,
//        pageRange: Int,
//        page: Int
//    ): Resource {

//    }

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