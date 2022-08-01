package com.example.data.model.detail


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.detail.DetailsAPIResponse
import com.google.gson.annotations.SerializedName

@Entity(tableName = "details_table")
data class DetailsAPIResponseImpl(
    @SerializedName("artObject") @PrimaryKey
    override val detailsArtObject: DetailsArtObjectImpl,
    @SerializedName("artObjectPage")
    override val artObjectPage: ArtObjectPage,
    @SerializedName("elapsedMilliseconds")
    override val elapsedMilliseconds: Int
) : DetailsAPIResponse