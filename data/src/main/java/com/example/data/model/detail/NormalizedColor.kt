package com.example.data.model.detail


import com.example.domain.model.detail.NormalizedColor
import com.google.gson.annotations.SerializedName

data class NormalizedColor(
    @SerializedName("hex")
    override val hex: String,
    @SerializedName("percentage")
    override val percentage: Int
) : NormalizedColor