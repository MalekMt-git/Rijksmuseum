package com.example.data.model.image


import com.example.domain.model.image.Tile
import com.google.gson.annotations.SerializedName

data class Tile(
    @SerializedName("url")
    override val url: String = "",
    @SerializedName("x")
    override val x: Int = 0,
    @SerializedName("y")
    override val y: Int = 0
) : Tile