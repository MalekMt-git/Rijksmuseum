package com.example.data.model.headline


import com.example.domain.model.headline.CountFacets
import com.google.gson.annotations.SerializedName

data class CountFacets(
    @SerializedName("hasimage")
    override val hasimage: Int,
    @SerializedName("ondisplay")
    override val ondisplay: Int
) : CountFacets