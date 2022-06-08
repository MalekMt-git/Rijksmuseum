package com.example.domain.model.headline


interface APIResponse {
    val artObjects: List<ArtObject>
    val count: Int
    val countFacets: CountFacets
    val elapsedMilliseconds: Int
    val facets: List<Facet>
}