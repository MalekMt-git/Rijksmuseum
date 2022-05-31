package nl.rijksmuseum.sample.data.model.headline


import com.google.gson.annotations.SerializedName

data class FacetX(
    @SerializedName("key")
    val key: String,
    @SerializedName("value")
    val value: Int
)