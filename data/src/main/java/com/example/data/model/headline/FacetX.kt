package com.example.data.model.headline


import com.example.domain.model.headline.FacetX
import com.google.gson.annotations.SerializedName

data class FacetX(
    @SerializedName("key")
    override val key: String,
    @SerializedName("value")
    override val value: Int
) : FacetX