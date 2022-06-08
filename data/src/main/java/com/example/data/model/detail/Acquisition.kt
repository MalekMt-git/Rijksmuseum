package com.example.data.model.detail


import com.example.domain.model.detail.Acquisition
import com.google.gson.annotations.SerializedName

data class Acquisition(
    @SerializedName("creditLine")
    override val creditLine: Any?,
    @SerializedName("date")
    override val date: String,
    @SerializedName("method")
    override val method: String
) : Acquisition