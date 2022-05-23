package nl.rijksmuseum.sample.data.model.headline


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("artObjects")
    val artObjects: List<ArtObject>,
    @SerializedName("count")
    val count: Int,
    @SerializedName("countFacets")
    val countFacets: CountFacets,
    @SerializedName("elapsedMilliseconds")
    val elapsedMilliseconds: Int,
    @SerializedName("facets")
    val facets: List<Facet>
)