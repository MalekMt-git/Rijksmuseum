package com.example.domain.usecase

import com.example.domain.repository.ArtObjectRepository

class DeleteSavedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun <ArtObject>execute(artObject: ArtObject) = artObjectRepository.deleteSavedArtObject(artObject)
}