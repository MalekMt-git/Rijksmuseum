package com.example.data.model.query

import android.os.Parcelable
import com.example.domain.model.query.ArtObjectDetailsQuery
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArtObjectDetailsQueryImpl(
    override val objectId: String,
    override val language: String
    ): Parcelable , ArtObjectDetailsQuery

