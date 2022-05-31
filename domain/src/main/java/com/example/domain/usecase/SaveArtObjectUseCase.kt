package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository

class SaveArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun <ArtObject>execute(artObject: ArtObject)= artObjectRepository.saveArtObject(artObject)
}