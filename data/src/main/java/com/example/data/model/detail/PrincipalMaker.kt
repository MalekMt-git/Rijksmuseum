package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class PrincipalMaker(
    @SerializedName("biography")
    val biography: Any?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("dateOfBirthPrecision")
    val dateOfBirthPrecision: Any?,
    @SerializedName("dateOfDeath")
    val dateOfDeath: String,
    @SerializedName("dateOfDeathPrecision")
    val dateOfDeathPrecision: Any?,
    @SerializedName("labelDesc")
    val labelDesc: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nationality")
    val nationality: Any?,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("placeOfBirth")
    val placeOfBirth: String,
    @SerializedName("placeOfDeath")
    val placeOfDeath: String,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>,
    @SerializedName("qualification")
    val qualification: Any?,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("unFixedName")
    val unFixedName: String
)