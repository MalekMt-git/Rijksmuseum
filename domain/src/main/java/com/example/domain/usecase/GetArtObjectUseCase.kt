package com.example.domain.usecase

import com.example.common_architecture.util.Resource
import com.example.domain.model.headline.APIResponse
import com.example.domain.repository.ArtObjectRepository


class GetArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(language : String,
                        pageRange: Int,
                        page : Int): Resource<APIResponse> {
        return artObjectRepository.getArtObjects(language=language,
            pageRange=pageRange,
            page=page)
    }
}