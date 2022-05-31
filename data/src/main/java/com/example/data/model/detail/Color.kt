package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class Color(
    @SerializedName("hex")
    val hex: String,
    @SerializedName("percentage")
    val percentage: Int
)