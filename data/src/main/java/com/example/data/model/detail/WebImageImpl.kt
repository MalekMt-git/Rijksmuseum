package com.example.data.model.detail


import com.example.domain.model.detail.WebImage
import com.google.gson.annotations.SerializedName

data class WebImageImpl(
    @SerializedName("guid")
    override val guid: String,
    @SerializedName("height")
    override val height: Int,
    @SerializedName("offsetPercentageX")
    override val offsetPercentageX: Int,
    @SerializedName("offsetPercentageY")
    override val offsetPercentageY: Int,
    @SerializedName("url")
    override val url: String,
    @SerializedName("width")
    override val width: Int
) : WebImage