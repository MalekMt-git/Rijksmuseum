package com.example.data.model.detail


import com.example.domain.model.detail.Classification
import com.google.gson.annotations.SerializedName

data class Classification(
    @SerializedName("events")
    override val events: List<Any>,
    @SerializedName("iconClassDescription")
    override val iconClassDescription: List<String>,
    @SerializedName("iconClassIdentifier")
    override val iconClassIdentifier: List<String>,
    @SerializedName("motifs")
    override val motifs: List<Any>,
    @SerializedName("objectNumbers")
    override val objectNumbers: List<String>,
    @SerializedName("people")
    override val people: List<String>,
    @SerializedName("periods")
    override val periods: List<Any>,
    @SerializedName("places")
    override val places: List<Any>
) : Classification