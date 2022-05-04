package nl.rijksmuseum.sample.domain.repository

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.model.headline.ArtObject
import nl.rijksmuseum.sample.data.util.Resource

interface ArtObjectRepository {

    suspend fun getArtObject(language : String,
                             pageRange: Int,
                             page : Int) : Resource<APIResponse>
    suspend fun getSearchedArtObject(searchQuery: String) : Resource<APIResponse>
    suspend fun saveArtObject(artObject: ArtObject)
    suspend fun deleteSavedArtObject(artObject: ArtObject)
    fun getSavedArtObjects() : Flow<List<ArtObject>>

}