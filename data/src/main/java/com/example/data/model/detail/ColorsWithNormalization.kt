package com.example.data.model.detail


import com.example.domain.model.detail.ColorsWithNormalization
import com.google.gson.annotations.SerializedName

data class ColorsWithNormalization(
    @SerializedName("normalizedHex")
    override val normalizedHex: String,
    @SerializedName("originalHex")
    override val originalHex: String
) : ColorsWithNormalization