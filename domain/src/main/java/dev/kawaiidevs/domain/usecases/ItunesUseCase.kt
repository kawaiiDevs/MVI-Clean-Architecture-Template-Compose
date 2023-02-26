package dev.kawaiidevs.domain.usecases

import dev.kawaiidevs.domain.ResultItunes
import dev.kawaiidevs.domain.model.SearchEntity
import kotlinx.coroutines.flow.Flow

interface ItunesUseCase {
    suspend fun getItunesList(artistName: String): Flow<ResultItunes<SearchEntity>>
}