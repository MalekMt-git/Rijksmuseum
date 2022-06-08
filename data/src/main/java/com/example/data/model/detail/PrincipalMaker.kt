package com.example.data.model.detail


import com.example.domain.model.detail.PrincipalMaker
import com.google.gson.annotations.SerializedName

data class PrincipalMaker(
    @SerializedName("biography")
    override val biography: Any?,
    @SerializedName("dateOfBirth")
    override val dateOfBirth: String,
    @SerializedName("dateOfBirthPrecision")
    override val dateOfBirthPrecision: Any?,
    @SerializedName("dateOfDeath")
    override val dateOfDeath: String,
    @SerializedName("dateOfDeathPrecision")
    override val dateOfDeathPrecision: Any?,
    @SerializedName("labelDesc")
    override val labelDesc: String,
    @SerializedName("name")
    override val name: String,
    @SerializedName("nationality")
    override val nationality: Any?,
    @SerializedName("occupation")
    override val occupation: List<String>,
    @SerializedName("placeOfBirth")
    override val placeOfBirth: String,
    @SerializedName("placeOfDeath")
    override val placeOfDeath: String,
    @SerializedName("productionPlaces")
    override val productionPlaces: List<String>,
    @SerializedName("qualification")
    override val qualification: Any?,
    @SerializedName("roles")
    override val roles: List<String>,
    @SerializedName("unFixedName")
    override val unFixedName: String
) : PrincipalMaker