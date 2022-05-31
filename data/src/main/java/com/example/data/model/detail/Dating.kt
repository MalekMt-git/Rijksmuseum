package com.example.data.model.detail


import com.google.gson.annotations.SerializedName

data class Dating(
    @SerializedName("period")
    val period: Int,
    @SerializedName("presentingDate")
    val presentingDate: String,
    @SerializedName("sortingDate")
    val sortingDate: Int,
    @SerializedName("yearEarly")
    val yearEarly: Int,
    @SerializedName("yearLate")
    val yearLate: Int
)