package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class GetArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(language : String): Resource<APIResponse>{
        return artObjectRepository.getArtObject(language)
    }
}