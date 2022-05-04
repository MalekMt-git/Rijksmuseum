package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class Acquisition(
    @SerializedName("creditLine")
    val creditLine: Any?,
    @SerializedName("date")
    val date: String,
    @SerializedName("method")
    val method: String
)