package nl.rijksmuseum.sample.domain.usecase

import kotlinx.coroutines.flow.Flow
import nl.rijksmuseum.sample.data.model.ArtObject
import nl.rijksmuseum.sample.domain.repository.CollectionRepository

class GetSavedCollectionUseCase(private val collectionRepository: CollectionRepository)  {
     fun execute(): Flow<List<ArtObject>> {
        return collectionRepository.getSavedCollection()
     }
}