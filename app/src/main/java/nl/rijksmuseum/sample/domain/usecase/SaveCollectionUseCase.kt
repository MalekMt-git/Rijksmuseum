package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.domain.repository.CollectionRepository

class SaveCollectionUseCase(private val collectionRepository: CollectionRepository) {
    suspend fun execute(article: ArtObject)= collectionRepository.saveCollection(article)
}