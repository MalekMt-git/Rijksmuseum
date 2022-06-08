package com.example.data.model.detail


import com.google.gson.annotations.SerializedName
import com.example.domain.model.detail.Dating

data class Dating(
    @SerializedName("period")
    override val period: Int,
    @SerializedName("presentingDate")
    override val presentingDate: String,
    @SerializedName("sortingDate")
    override val sortingDate: Int,
    @SerializedName("yearEarly")
    override val yearEarly: Int,
    @SerializedName("yearLate")
    override val yearLate: Int
) : Dating