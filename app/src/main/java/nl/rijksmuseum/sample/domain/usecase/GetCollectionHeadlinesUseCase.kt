package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.CollectionRepository

class GetCollectionHeadlinesUseCase(private val collectionRepository: CollectionRepository) {

    suspend fun execute(): Resource<APIResponse>{
        return collectionRepository.getCollectionHeadlines()
    }

}