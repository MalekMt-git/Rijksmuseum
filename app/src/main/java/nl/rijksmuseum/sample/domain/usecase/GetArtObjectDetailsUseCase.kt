package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.detail.DetailsAPIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class GetArtObjectDetailsUseCase(private val artObjectRepository: ArtObjectRepository) {

    suspend fun execute(objectId : String, language: String) : Resource<DetailsAPIResponse>{
        return artObjectRepository.getArtObjectDetails(objectId, language)
    }
}
