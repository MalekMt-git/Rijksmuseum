package com.example.data.model.headline


import com.example.domain.model.headline.WebImage
import com.google.gson.annotations.SerializedName

data class WebImage(
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