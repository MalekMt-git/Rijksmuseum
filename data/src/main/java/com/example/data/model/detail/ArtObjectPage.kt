package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class ArtObjectPage(
    @SerializedName("adlibOverrides")
    val adlibOverrides: AdlibOverrides,
    @SerializedName("audioFile1")
    val audioFile1: Any?,
    @SerializedName("audioFileLabel1")
    val audioFileLabel1: Any?,
    @SerializedName("audioFileLabel2")
    val audioFileLabel2: Any?,
    @SerializedName("createdOn")
    val createdOn: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("objectNumber")
    val objectNumber: String,
    @SerializedName("plaqueDescription")
    val plaqueDescription: String,
    @SerializedName("similarPages")
    val similarPages: List<Any>,
    @SerializedName("tags")
    val tags: List<Any>,
    @SerializedName("updatedOn")
    val updatedOn: String
)