package com.example.domain.usecase

import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.detail.DetailsArtObject
import com.example.domain.repository.ArtObjectRepository

class DeleteSavedArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun execute(detailsArtObject: DetailsArtObject) = artObjectRepository.deleteSavedArtObjectDetails(detailsArtObject)
}