package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository

class GetArtObjectDetailsUseCase(private val artObjectRepository: ArtObjectRepository) {

    suspend fun<DetailsAPIResponse> execute(objectId : String, language: String) : DetailsAPIResponse{
        return artObjectRepository.getArtObjectDetails(objectId, language)
    }
}
