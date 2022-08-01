package com.example.domain.usecase

import com.example.common_architecture.util.Resource
import com.example.domain.model.detail.DetailsAPIResponse
import com.example.domain.model.detail.DetailsArtObject
import com.example.domain.model.query.ArtObjectDetailsQuery
import com.example.domain.repository.ArtObjectRepository

class GetArtObjectDetailsUseCase(private val artObjectRepository: ArtObjectRepository) {
    suspend fun getDetails(artObjectDetailsQuery: ArtObjectDetailsQuery): Resource<DetailsAPIResponse>
    = artObjectRepository.getArtObjectDetails(artObjectDetailsQuery)
}
