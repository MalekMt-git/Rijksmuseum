package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository


class GetArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun<APIResponse> execute(language : String,
                        pageRange: Int,
                        page : Int): APIResponse{
        return artObjectRepository.getArtObjects(language=language,
        pageRange=pageRange,
        page=page)
    }
}