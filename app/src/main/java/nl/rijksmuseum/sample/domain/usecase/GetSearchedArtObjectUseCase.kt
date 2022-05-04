package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class GetSearchedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return artObjectRepository.getSearchedArtObject(searchQuery)
    }
}