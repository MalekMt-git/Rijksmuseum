package com.example.domain.usecase

import com.example.domain.model.headline.ArtObject
import com.example.domain.repository.ArtObjectRepository

class SaveArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(artObject: ArtObject)= artObjectRepository.saveArtObject(artObject)
}