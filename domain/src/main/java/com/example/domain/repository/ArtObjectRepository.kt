package nl.rijksmuseum.sample.domain.repository

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.model.headline.ArtObject
import nl.rijksmuseum.sample.data.util.Resource

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