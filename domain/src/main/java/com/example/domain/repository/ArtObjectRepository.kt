package com.example.domain.repository

import com.example.common_architecture.util.Resource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.headline.APIResponse
import com.example.domain.model.headline.ArtObject
import kotlinx.coroutines.flow.Flow


interface ArtObjectRepository {
    suspend fun getArtObjects(language : String,
                              pageRange: Int,
                              page : Int) : Resource<APIResponse>
    suspend fun getSearchedArtObject(searchQuery: String) : Resource<APIResponse>
    suspend fun getArtObjectDetails(objectId: String, language: String) : Resource<DetailsAPIResponse>
    suspend fun saveArtObject(artObject: ArtObject)
    suspend fun deleteSavedArtObject(artObject: ArtObject)
    fun getSavedArtObjects() : Flow<List<ArtObject>>
}