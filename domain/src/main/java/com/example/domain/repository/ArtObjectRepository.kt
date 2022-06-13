package com.example.domain.repository

import androidx.paging.PagingData
import com.example.common_architecture.util.Resource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.headline.APIResponse
import com.example.domain.model.headline.ArtObject
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


interface ArtObjectRepository {
    fun getArtObjects(defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery, coroutineScope: CoroutineScope) : Flow<PagingData<out ArtObject>>
    suspend fun getSearchedArtObject(searchQuery: String) : Resource<APIResponse>
    suspend fun getArtObjectDetails(artObjectDetailsQuery: ArtObjectDetailsQuery) : Resource<DetailsAPIResponse>
    suspend fun saveArtObject(artObject: ArtObject)
    suspend fun deleteSavedArtObject(artObject: ArtObject)
    fun getSavedArtObjects() : Flow<List<ArtObject>>
}