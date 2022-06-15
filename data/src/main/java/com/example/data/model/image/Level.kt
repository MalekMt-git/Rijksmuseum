package com.example.data.model.image


import com.example.domain.model.image.Level
import com.google.gson.annotations.SerializedName

data class Level(
    @SerializedName("height")
    override val height: Int = 0,
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("tiles")
    override val tiles: List<Tile> = listOf(),
    @SerializedName("width")
    override val width: Int = 0
) : Level