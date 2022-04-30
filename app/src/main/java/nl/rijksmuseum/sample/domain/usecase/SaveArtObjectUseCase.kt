package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class SaveArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(artObject: ArtObject)= artObjectRepository.saveArtObject(artObject)
}