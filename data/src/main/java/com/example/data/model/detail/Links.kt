package com.example.data.model.detail


import com.example.domain.model.detail.Links
import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("search")
    override val search: String
) : Links