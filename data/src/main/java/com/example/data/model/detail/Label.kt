package com.example.data.model.detail


import com.example.domain.model.detail.Label
import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("date")
    override val date: String,
    @SerializedName("description")
    override val description: String,
    @SerializedName("makerLine")
    override val makerLine: String,
    @SerializedName("notes")
    override val notes: String,
    @SerializedName("title")
    override val title: String
) : Label