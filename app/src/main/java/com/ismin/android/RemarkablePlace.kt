package com.ismin.android

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Properties(
    @SerializedName("id") val id: Int,
    @SerializedName("CODE") val code: String,
    @SerializedName("type") val type: String,
    @SerializedName("COMMUNE") val commune: String,
    @SerializedName("LIBELLE") val libelle: String
) : Serializable

data class RemarkablePlace(
    @SerializedName("properties") val properties: Properties,
    @SerializedName("coordinates") val coordinates: List<Double>
) : Serializable