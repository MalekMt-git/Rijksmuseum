package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class ArtObject(
    @SerializedName("acquisition")
    val acquisition: Acquisition,
    @SerializedName("artistRole")
    val artistRole: Any?,
    @SerializedName("associations")
    val associations: List<Any>,
    @SerializedName("catRefRPK")
    val catRefRPK: List<Any>,
    @SerializedName("classification")
    val classification: Classification,
    @SerializedName("colors")
    val colors: List<Color>,
    @SerializedName("colorsWithNormalization")
    val colorsWithNormalization: List<ColorsWithNormalization>,
    @SerializedName("copyrightHolder")
    val copyrightHolder: Any?,
    @SerializedName("dating")
    val dating: Dating,
    @SerializedName("description")
    val description: String,
    @SerializedName("dimensions")
    val dimensions: List<Dimension>,
    @SerializedName("documentation")
    val documentation: List<String>,
    @SerializedName("exhibitions")
    val exhibitions: List<Any>,
    @SerializedName("hasImage")
    val hasImage: Boolean,
    @SerializedName("historicalPersons")
    val historicalPersons: List<String>,
    @SerializedName("id")
    val id: String,
    @SerializedName("inscriptions")
    val inscriptions: List<Any>,
    @SerializedName("label")
    val label: Label,
    @SerializedName("labelText")
    val labelText: Any?,
    @SerializedName("language")
    val language: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("location")
    val location: String,
    @SerializedName("longTitle")
    val longTitle: String,
    @SerializedName("makers")
    val makers: List<Any>,
    @SerializedName("materials")
    val materials: List<String>,
    @SerializedName("normalized32Colors")
    val normalized32Colors: List<Normalized32Color>,
    @SerializedName("normalizedColors")
    val normalizedColors: List<NormalizedColor>,
    @SerializedName("objectCollection")
    val objectCollection: List<String>,
    @SerializedName("objectNumber")
    val objectNumber: String,
    @SerializedName("objectTypes")
    val objectTypes: List<String>,
    @SerializedName("physicalMedium")
    val physicalMedium: String,
    @SerializedName("physicalProperties")
    val physicalProperties: List<Any>,
    @SerializedName("plaqueDescriptionDutch")
    val plaqueDescriptionDutch: String,
    @SerializedName("plaqueDescriptionEnglish")
    val plaqueDescriptionEnglish: String,
    @SerializedName("principalMaker")
    val principalMaker: String,
    @SerializedName("principalMakers")
    val principalMakers: List<PrincipalMaker>,
    @SerializedName("principalOrFirstMaker")
    val principalOrFirstMaker: String,
    @SerializedName("priref")
    val priref: String,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>,
    @SerializedName("scLabelLine")
    val scLabelLine: String,
    @SerializedName("showImage")
    val showImage: Boolean,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("techniques")
    val techniques: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("webImage")
    val webImage: WebImage
)