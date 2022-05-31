package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.headline.ArtObject
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class DeleteSavedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(artObject: ArtObject) = artObjectRepository.deleteSavedArtObject(artObject)
}