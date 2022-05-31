package com.example.domain.repository


interface ArtObjectRepository {

    suspend fun <Resource> getArtObjects(language : String,
                                                     pageRange: Int,
                                                     page : Int) : Resource
    suspend fun <APIResponse> getSearchedArtObject(searchQuery: String) : APIResponse
    suspend fun <DetailsAPIResponse> getArtObjectDetails(objectId: String, language: String): DetailsAPIResponse
    suspend fun <ArtObject> saveArtObject(artObject: ArtObject)
    suspend fun <ArtObject> deleteSavedArtObject(artObject: ArtObject)
    fun <ArtObject>getSavedArtObjects() : ArtObject
}