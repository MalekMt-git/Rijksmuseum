package com.example.data.model.headline

import com.example.domain.model.headline.APIResponse
import com.google.gson.annotations.SerializedName

data class APIResponseImpl(
    @SerializedName("artObjects")
    override val artObjects: List<ArtObject>,
    @SerializedName("count")
    override val count: Int,
    @SerializedName("countFacets")
    override val countFacets: CountFacets,
    @SerializedName("elapsedMilliseconds")
    override val elapsedMilliseconds: Int,
    @SerializedName("facets")
    override val facets: List<Facet>
) : APIResponse