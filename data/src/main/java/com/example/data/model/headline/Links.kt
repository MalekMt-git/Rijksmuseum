package com.example.data.model.headline


import com.example.domain.model.headline.Links
import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    override val self: String,
    @SerializedName("web")
    override val web: String
) : Links