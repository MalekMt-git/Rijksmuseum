package com.example.data.model.detail


import com.example.domain.model.detail.ArtObjectPage
import com.google.gson.annotations.SerializedName

data class ArtObjectPage(
    @SerializedName("adlibOverrides")
    override val adlibOverrides: AdlibOverrides,
    @SerializedName("audioFile1")
    override val audioFile1: Any?,
    @SerializedName("audioFileLabel1")
    override val audioFileLabel1: Any?,
    @SerializedName("audioFileLabel2")
    override val audioFileLabel2: Any?,
    @SerializedName("createdOn")
    override val createdOn: String,
    @SerializedName("id")
    override val id: String,
    @SerializedName("lang")
    override val lang: String,
    @SerializedName("objectNumber")
    override val objectNumber: String,
    @SerializedName("plaqueDescription")
    override val plaqueDescription: String,
    @SerializedName("similarPages")
    override val similarPages: List<Any>,
    @SerializedName("tags")
    override val tags: List<Any>,
    @SerializedName("updatedOn")
    override val updatedOn: String
) : ArtObjectPage