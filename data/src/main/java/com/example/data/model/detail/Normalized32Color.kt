package com.example.data.model.detail


import com.example.domain.model.detail.Normalized32Color
import com.google.gson.annotations.SerializedName

data class Normalized32Color(
    @SerializedName("hex")
    override val hex: String,
    @SerializedName("percentage")
    override val percentage: Int
) : Normalized32Color