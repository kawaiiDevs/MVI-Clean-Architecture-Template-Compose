package dev.kawaiidevs.domain.repository

import dev.kawaiidevs.domain.ResultItunes
import dev.kawaiidevs.domain.model.SearchEntity
import kotlinx.coroutines.flow.Flow

interface ItunesRepository {
    suspend fun getItunesList(artistName: String): Flow<ResultItunes<SearchEntity>>
}