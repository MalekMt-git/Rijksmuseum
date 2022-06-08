package com.example.data.model.detail

import com.example.domain.model.detail.Color
import com.google.gson.annotations.SerializedName

data class Color(
    @SerializedName("hex")
    override val hex: String,
    @SerializedName("percentage")
    override val percentage: Int
) : Color