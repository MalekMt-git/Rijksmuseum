package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository

class GetSavedArtObjectsUseCase(private val artObjectRepository: ArtObjectRepository)  {
     fun <ArtObject>execute(): ArtObject {
        return artObjectRepository.getSavedArtObjects()
     }
}