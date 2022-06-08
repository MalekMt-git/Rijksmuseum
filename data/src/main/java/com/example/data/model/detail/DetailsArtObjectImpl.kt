package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class DetailsArtObjectImpl(
    @SerializedName("acquisition")
    override val acquisition: Acquisition,
    @SerializedName("artistRole")
    override val artistRole: Any?,
    @SerializedName("associations")
    override val associations: List<Any>,
    @SerializedName("catRefRPK")
    override val catRefRPK: List<Any>,
    @SerializedName("classification")
    override val classification: Classification,
    @SerializedName("colors")
    override val colors: List<Color>,
    @SerializedName("colorsWithNormalization")
    override val colorsWithNormalization: List<ColorsWithNormalization>,
    @SerializedName("copyrightHolder")
    override val copyrightHolder: Any?,
    @SerializedName("dating")
    override val dating: Dating,
    @SerializedName("description")
    override val description: String,
    @SerializedName("dimensions")
    override val dimensions: List<Dimension>,
    @SerializedName("documentation")
    override val documentation: List<String>,
    @SerializedName("exhibitions")
    override val exhibitions: List<Any>,
    @SerializedName("hasImage")
    override val hasImage: Boolean,
    @SerializedName("historicalPersons")
    override val historicalPersons: List<String>,
    @SerializedName("id")
    override val id: String,
    @SerializedName("inscriptions")
    override val inscriptions: List<Any>,
    @SerializedName("label")
    override val label: Label,
    @SerializedName("labelText")
    override val labelText: Any?,
    @SerializedName("language")
    override val language: String,
    @SerializedName("links")
    override val links: Links,
    @SerializedName("location")
    override val location: String,
    @SerializedName("longTitle")
    override val longTitle: String,
    @SerializedName("makers")
    override val makers: List<Any>,
    @SerializedName("materials")
    override val materials: List<String>,
    @SerializedName("normalized32Colors")
    override val normalized32Colors: List<Normalized32Color>,
    @SerializedName("normalizedColors")
    override val normalizedColors: List<NormalizedColor>,
    @SerializedName("objectCollection")
    override val objectCollection: List<String>,
    @SerializedName("objectNumber")
    override val objectNumber: String,
    @SerializedName("objectTypes")
    override val objectTypes: List<String>,
    @SerializedName("physicalMedium")
    override val physicalMedium: String,
    @SerializedName("physicalProperties")
    override val physicalProperties: List<Any>,
    @SerializedName("plaqueDescriptionDutch")
    override val plaqueDescriptionDutch: String,
    @SerializedName("plaqueDescriptionEnglish")
    override val plaqueDescriptionEnglish: String,
    @SerializedName("principalMaker")
    override val principalMaker: String,
    @SerializedName("principalMakers")
    override val principalMakers: List<PrincipalMaker>,
    @SerializedName("principalOrFirstMaker")
    override val principalOrFirstMaker: String,
    @SerializedName("priref")
    override val priref: String,
    @SerializedName("productionPlaces")
    override val productionPlaces: List<String>,
    @SerializedName("scLabelLine")
    override val scLabelLine: String,
    @SerializedName("showImage")
    override val showImage: Boolean,
    @SerializedName("subTitle")
    override val subTitle: String,
    @SerializedName("techniques")
    override val techniques: List<String>,
    @SerializedName("title")
    override val title: String,
    @SerializedName("titles")
    override val titles: List<String>,
    @SerializedName("webImage") override val webImage: WebImageImpl
) : com.example.domain.model.detail.DetailsArtObject