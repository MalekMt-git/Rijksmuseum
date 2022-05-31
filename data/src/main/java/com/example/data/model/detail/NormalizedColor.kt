package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class NormalizedColor(
    @SerializedName("hex")
    val hex: String,
    @SerializedName("percentage")
    val percentage: Int
)