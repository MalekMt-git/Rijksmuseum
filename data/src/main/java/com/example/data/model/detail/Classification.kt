package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class Classification(
    @SerializedName("events")
    val events: List<Any>,
    @SerializedName("iconClassDescription")
    val iconClassDescription: List<String>,
    @SerializedName("iconClassIdentifier")
    val iconClassIdentifier: List<String>,
    @SerializedName("motifs")
    val motifs: List<Any>,
    @SerializedName("objectNumbers")
    val objectNumbers: List<String>,
    @SerializedName("people")
    val people: List<String>,
    @SerializedName("periods")
    val periods: List<Any>,
    @SerializedName("places")
    val places: List<Any>
)