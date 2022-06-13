package com.example.data.repository.dataSource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.data.api.ArtObjectAPIService
import com.example.data.model.query.ArtObjectHeadlinesQueryImpl
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import kotlinx.coroutines.CoroutineScope
import retrofit2.Response

class ArtObjectRemoteDataSource(
    private val artObjectAPIService: ArtObjectAPIService,
    ) {
     fun getArtObjects(defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery, coroutineScope : CoroutineScope )
     = Pager(config = PagingConfig(pageSize = defaultArtObjectHeadlinesQuery.pageRange, enablePlaceholders = false),
         pagingSourceFactory = { ArtObjectPagingSource(defaultArtObjectHeadlinesQuery as ArtObjectHeadlinesQueryImpl, artObjectAPIService) }
     ).flow.cachedIn(coroutineScope)

    suspend fun getArtObjectDetails(
        artObjectDetailsQuery: ArtObjectDetailsQuery
    ): Response<out DetailsAPIResponse> {
        return artObjectAPIService.getArtObjectDetails(language = artObjectDetailsQuery.language, objectId = artObjectDetailsQuery.objectId)
    }
}
