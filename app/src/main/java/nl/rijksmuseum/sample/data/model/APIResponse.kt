package nl.rijksmuseum.sample.data.model

data class APIResponse(
    val artObjects: List<ArtObject>,
    val count: Int,
    val countFacets: CountFacets,
    val elapsedMilliseconds: Int,
    val facets: List<Facet>
)