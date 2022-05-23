package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class ColorsWithNormalization(
    @SerializedName("normalizedHex")
    val normalizedHex: String,
    @SerializedName("originalHex")
    val originalHex: String
)