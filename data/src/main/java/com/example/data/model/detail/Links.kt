package nl.rijksmuseum.sample.data.model.detail


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("search")
    val search: String
)