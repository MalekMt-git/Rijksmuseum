package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.model.headline.ArtObject
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import com.example.domain.repository.ArtObjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


class GetArtObjectUseCase(private val artObjectRepository: ArtObjectRepository) {
     fun execute(defaultArtObjectHeadlinesQuery: ArtObjectHeadlinesQuery , coroutineScope: CoroutineScope): Flow<PagingData<out ArtObject>>
    = artObjectRepository.getArtObjects(defaultArtObjectHeadlinesQuery,coroutineScope)
}