package com.example.domain.usecase

import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.detail.DetailsArtObject
import com.example.domain.repository.ArtObjectRepository
import kotlinx.coroutines.flow.Flow

class GetSavedArtObjectsUseCase(private val artObjectRepository: ArtObjectRepository)  {
    fun execute(): Flow<List<DetailsArtObject>> {
        return artObjectRepository.getSavedArtObjectsDetails()
    }
}