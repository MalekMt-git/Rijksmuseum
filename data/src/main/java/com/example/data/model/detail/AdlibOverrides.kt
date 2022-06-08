package com.example.data.model.detail


import com.example.domain.model.detail.AdlibOverrides
import com.google.gson.annotations.SerializedName

data class AdlibOverrides(
    @SerializedName("etiketText")
    override val etiketText: Any?,
    @SerializedName("maker")
    override val maker: Any?,
    @SerializedName("titel")
    override val titel: Any?
) : AdlibOverrides