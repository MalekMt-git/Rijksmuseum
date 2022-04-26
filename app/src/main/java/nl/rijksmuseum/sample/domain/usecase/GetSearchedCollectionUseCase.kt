package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.CollectionRepository

class GetSearchedCollectionUseCase(private val collectionRepository: CollectionRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return collectionRepository.getSearchedCollection(searchQuery)
    }
}