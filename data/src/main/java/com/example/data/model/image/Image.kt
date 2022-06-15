package com.example.data.model.image


import com.example.domain.model.image.Image
import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("levels")
    override val levels: List<Level> = listOf()
) : Image