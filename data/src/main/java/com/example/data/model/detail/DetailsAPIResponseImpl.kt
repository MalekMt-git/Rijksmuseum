package com.example.data.model.detail


import com.example.domain.model.detail.ArtObject
import com.example.domain.model.detail.DetailsAPIResponse
import com.google.gson.annotations.SerializedName

data class DetailsAPIResponseImpl(
    @SerializedName("artObject")
    override val artObject: ArtObject,
    @SerializedName("artObjectPage")
    override val artObjectPage: ArtObjectPage,
    @SerializedName("elapsedMilliseconds")
    override val elapsedMilliseconds: Int
) : DetailsAPIResponse