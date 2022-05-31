package com.example.data.model.detail


import com.example.data.model.headline.ArtObject
import com.google.gson.annotations.SerializedName

data class DetailsAPIResponse(
    @SerializedName("artObject")
    val artObject: ArtObject,
    @SerializedName("artObjectPage")
    val artObjectPage: ArtObjectPage,
    @SerializedName("elapsedMilliseconds")
    val elapsedMilliseconds: Int
)