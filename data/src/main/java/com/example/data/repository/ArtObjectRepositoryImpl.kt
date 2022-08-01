package com.example.data.repository

import androidx.paging.PagingData
import com.example.common_architecture.util.Resource
import com.example.data.repository.dataSource.ArtObjectDataSource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.detail.DetailsArtObject
import com.example.domain.model.headline.APIResponse
import com.example.domain.model.headline.ArtObject
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import com.example.domain.repository.ArtObjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


class ArtObjectRepositoryImpl(private val artObjectDataSource: ArtObjectDataSource) : ArtObjectRepository {

    override fun getArtObjects(
        defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery,
        coroutineScope: CoroutineScope
    ): Flow<PagingData<out ArtObject>> = artObjectDataSource.getArtObjects(defaultArtObjectHeadlinesQuery,coroutineScope)

    override suspend fun getArtObjectDetails(
        artObjectDetailsQuery: ArtObjectDetailsQuery
    ): Resource<DetailsAPIResponse> = responseToResource(artObjectDataSource.getArtObjectDetails(artObjectDetailsQuery))

    override suspend fun getSearchedArtObject(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArtObjectDetails(detailsArtObject: DetailsArtObject) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSavedArtObjectDetails(detailsArtObject: DetailsArtObject) {
        TODO("Not yet implemented")
    }

    override fun getSavedArtObjectsDetails(): Flow<List<DetailsArtObject>> {
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