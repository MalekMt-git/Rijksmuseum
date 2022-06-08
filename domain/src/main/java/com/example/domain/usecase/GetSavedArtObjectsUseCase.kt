package com.example.domain.usecase

import com.example.domain.model.headline.ArtObject
import com.example.domain.repository.ArtObjectRepository
import kotlinx.coroutines.flow.Flow

class GetSavedArtObjectsUseCase(private val artObjectRepository: ArtObjectRepository)  {
    fun execute(): Flow<List<ArtObject>> {
        return artObjectRepository.getSavedArtObjects()
    }
}