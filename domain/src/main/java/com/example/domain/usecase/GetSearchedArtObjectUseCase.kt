package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository

class GetSearchedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun<APIResponse> execute(searchQuery: String): APIResponse {
        return artObjectRepository.getSearchedArtObject(searchQuery)
    }
}