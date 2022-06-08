package com.example.data.model.headline


import com.example.domain.model.headline.ArtObject
import com.google.gson.annotations.SerializedName

data class ArtObject(
    @SerializedName("hasImage")
    override val hasImage: Boolean,
    @SerializedName("headerImage")
    override val headerImage: HeaderImage,
    @SerializedName("id")
    override val id: String,
    @SerializedName("links")
    override val links: Links,
    @SerializedName("longTitle")
    override val longTitle: String,
    @SerializedName("objectNumber")
    override val objectNumber: String,
    @SerializedName("permitDownload")
    override val permitDownload: Boolean,
    @SerializedName("principalOrFirstMaker")
    override val principalOrFirstMaker: String,
    @SerializedName("productionPlaces")
    override val productionPlaces: List<String>,
    @SerializedName("showImage")
    override val showImage: Boolean,
    @SerializedName("title")
    override val title: String,
    @SerializedName("webImage")
    override val webImage: WebImage
) : ArtObject