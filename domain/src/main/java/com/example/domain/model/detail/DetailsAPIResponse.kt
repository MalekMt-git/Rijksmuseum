package com.example.domain.model.detail

interface DetailsAPIResponse{
    val detailsArtObject: DetailsArtObject
    val artObjectPage: ArtObjectPage
    val elapsedMilliseconds: Int
}