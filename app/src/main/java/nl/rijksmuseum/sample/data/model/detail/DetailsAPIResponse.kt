package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class DetailsAPIResponse(
    @SerializedName("artObject")
    val artObject: ArtObject,
    @SerializedName("artObjectPage")
    val artObjectPage: ArtObjectPage,
    @SerializedName("elapsedMilliseconds")
    val elapsedMilliseconds: Int
)