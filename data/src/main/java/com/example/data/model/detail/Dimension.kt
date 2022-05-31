package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class Dimension(
    @SerializedName("part")
    val part: Any?,
    @SerializedName("precision")
    val precision: Any?,
    @SerializedName("type")
    val type: String,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: String
)