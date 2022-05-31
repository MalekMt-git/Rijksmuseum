package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class Normalized32Color(
    @SerializedName("hex")
    val hex: String,
    @SerializedName("percentage")
    val percentage: Int
)