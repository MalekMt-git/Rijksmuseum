package nl.rijksmuseum.sample.domain.usecase

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class GetSavedArtObjectsUseCase(private val artObjectRepository: ArtObjectRepository)  {
     fun execute(): Flow<List<ArtObject>> {
        return artObjectRepository.getSavedArtObjects()
     }
}