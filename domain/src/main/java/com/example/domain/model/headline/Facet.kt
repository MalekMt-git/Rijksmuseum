package com.example.domain.model.headline



interface Facet{
    val facets: List<FacetX>
    val name: String
    val otherTerms: Int
    val prettyName: Int
}