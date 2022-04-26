package nl.rijksmuseum.sample.domain.repository

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.data.util.Resource

interface CollectionRepository {

    suspend fun getCollectionHeadlines() : Resource<APIResponse>
    suspend fun getSearchedCollection(searchQuery: String) : Resource<APIResponse>
    suspend fun saveCollection(article: ArtObject)
    suspend fun deleteSavedCollection(article: ArtObject)
    fun getSavedCollection() : Flow<List<ArtObject>>

}