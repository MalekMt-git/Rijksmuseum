package nl.rijksmuseum.sample.domain.usecase

import nl.rijksmuseum.sample.data.model.headline.APIResponse
import nl.rijksmuseum.sample.data.util.Resource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository

class GetArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(language : String,
                        pageRange: Int,
                        page : Int): Resource<APIResponse>{
        return artObjectRepository.getArtObjects(language=language,
        pageRange=pageRange,
        page=page)
    }
}