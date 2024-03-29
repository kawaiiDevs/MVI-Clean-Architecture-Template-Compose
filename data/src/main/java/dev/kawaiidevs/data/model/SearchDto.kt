package dev.kawaiidevs.data.model

import com.google.gson.annotations.SerializedName

data class SearchDto(
    @SerializedName("resultCount")
    val searchCount: Int?,
    @SerializedName("results")
    val itunesList: List<ItunesDto>
)