package dev.kawaiidevs.domain.model

import dev.kawaiidevs.domain.constants.EMPTY_INT

data class SearchEntity(
    val searchCount: Int? = EMPTY_INT,
    val itunesList: List<ItunesEntity>? = emptyList()
)