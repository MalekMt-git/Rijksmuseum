package com.example.domain.usecase

import com.example.common_architecture.util.Resource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.repository.ArtObjectRepository

class GetArtObjectDetailsUseCase(private val artObjectRepository: ArtObjectRepository) {

    suspend fun execute(objectId : String, language: String) : Resource<DetailsAPIResponse> {
        return artObjectRepository.getArtObjectDetails(objectId, language)
    }
}
