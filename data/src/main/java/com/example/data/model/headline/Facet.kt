package com.example.data.model.headline


import com.example.domain.model.headline.Facet
import com.google.gson.annotations.SerializedName

data class Facet(
    @SerializedName("facets")
    override val facets: List<FacetX>,
    @SerializedName("name")
    override val name: String,
    @SerializedName("otherTerms")
    override val otherTerms: Int,
    @SerializedName("prettyName")
    override val prettyName: Int
) : Facet