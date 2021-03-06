package com.example.domain.model.detail

interface DetailsArtObject{
    val acquisition: Acquisition
    val artistRole: Any?
    val associations: List<Any>
    val catRefRPK: List<Any>
    val classification: Classification
    val colors: List<Color>
    val colorsWithNormalization: List<ColorsWithNormalization>
    val copyrightHolder: Any?
    val dating: Dating
    val description: String
    val dimensions: List<Dimension>
    val documentation: List<String>
    val exhibitions: List<Any>
    val hasImage: Boolean
    val historicalPersons: List<String>
    val id: String
    val inscriptions: List<Any>
    val label: Label
    val labelText: Any?
    val language: String
    val links: Links
    val location: String
    val longTitle: String
    val makers: List<Any>
    val materials: List<String>
    val normalized32Colors: List<Normalized32Color>
    val normalizedColors: List<NormalizedColor>
    val objectCollection: List<String>
    val objectNumber: String
    val objectTypes: List<String>
    val physicalMedium: String
    val physicalProperties: List<Any>
    val plaqueDescriptionDutch: String
    val plaqueDescriptionEnglish: String
    val principalMaker: String
    val principalMakers: List<PrincipalMaker>
    val principalOrFirstMaker: String
    val priref: String
    val productionPlaces: List<String>
    val scLabelLine: String
    val showImage: Boolean
    val subTitle: String
    val techniques: List<String>
    val title: String
    val titles: List<String>
    val webImage: WebImage
}