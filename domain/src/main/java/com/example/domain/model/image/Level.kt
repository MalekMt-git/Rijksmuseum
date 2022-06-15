package com.example.domain.model.image


interface Level{
    val height: Int
    val name: String
    val tiles: List<Tile>
    val width: Int
}