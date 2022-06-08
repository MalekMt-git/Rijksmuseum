package com.example.domain.usecase

import com.example.common_architecture.util.Resource
import com.example.domain.model.headline.APIResponse
import com.example.domain.repository.ArtObjectRepository

class GetSearchedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return artObjectRepository.getSearchedArtObject(searchQuery)
    }
}