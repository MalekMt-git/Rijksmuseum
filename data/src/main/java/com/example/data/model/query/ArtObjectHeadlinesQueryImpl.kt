package com.example.data.model.query

import com.example.domain.model.query.ArtObjectHeadlinesQuery
data class ArtObjectHeadlinesQueryImpl(
    override val language: String,
    override val pageRange: Int,
    override val page: Int
) : ArtObjectHeadlinesQuery
