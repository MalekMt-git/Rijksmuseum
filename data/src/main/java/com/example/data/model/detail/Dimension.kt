package com.example.data.model.detail


import com.example.domain.model.detail.Dimension
import com.google.gson.annotations.SerializedName

data class Dimension(
    @SerializedName("part")
    override val part: Any?,
    @SerializedName("precision")
    override val precision: Any?,
    @SerializedName("type")
    override val type: String,
    @SerializedName("unit")
    override val unit: String,
    @SerializedName("value")
    override val value: String
) : Dimension