package com.example.domain.model.headline



interface ArtObject {
    val hasImage: Boolean
    val headerImage: HeaderImage
    val id: String
    val links: Links
    val longTitle: String
    val objectNumber: String
    val permitDownload: Boolean
    val principalOrFirstMaker: String
    val productionPlaces: List<String>
    val showImage: Boolean
    val title: String
    val webImage: WebImage
}