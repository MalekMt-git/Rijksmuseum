package com.example.data.repository

import androidx.paging.PagingData
import com.example.common_architecture.util.Resource
import com.example.data.repository.dataSource.ArtObjectRemoteDataSource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.headline.APIResponse
import com.example.domain.model.headline.ArtObject
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import com.example.domain.repository.ArtObjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


class ArtObjectRepositoryImpl(private val artObjectRemoteDataSource: ArtObjectRemoteDataSource) : ArtObjectRepository {

    override fun getArtObjects(
        defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery,
        coroutineScope: CoroutineScope
    ): Flow<PagingData<out ArtObject>> = artObjectRemoteDataSource.getArtObjects(defaultArtObjectHeadlinesQuery,coroutineScope)

    override suspend fun getArtObjectDetails(
        artObjectDetailsQuery: ArtObjectDetailsQuery
    ): Resource<DetailsAPIResponse> = responseToResource(artObjectRemoteDataSource.getArtObjectDetails(artObjectDetailsQuery))

    override suspend fun getArtObjectImages(artObjectDetailsQuery: ArtObjectDetailsQuery)
    = responseToResource(artObjectRemoteDataSource.getArtObjectImages(artObjectDetailsQuery))


    override suspend fun getSearchedArtObject(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
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

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}