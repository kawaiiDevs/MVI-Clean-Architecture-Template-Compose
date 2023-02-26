package dev.kawaiidevs.data.network

import dev.kawaiidevs.data.model.SearchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search")
    suspend fun getItunesList(
        @Query("term") term: String,
        @Query("entity") entity: String, //album
        @Query("attribute") attribute: String,
        @Query("limit") limit: Int
    ): Response<SearchDto>
}