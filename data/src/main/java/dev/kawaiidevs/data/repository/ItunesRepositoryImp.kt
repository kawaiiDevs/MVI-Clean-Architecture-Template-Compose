package dev.kawaiidevs.data.repository

import dagger.hilt.android.scopes.ActivityScoped
import dev.kawaiidevs.data.model.mapToDomain
import dev.kawaiidevs.data.network.Api
import dev.kawaiidevs.data.retrofit.executeRetrofitRequest
import dev.kawaiidevs.data.retrofit.handleResultRetrofit
import dev.kawaiidevs.domain.ResultItunes
import dev.kawaiidevs.domain.constants.ITUNES_DEFAULT_LIMIT
import dev.kawaiidevs.domain.constants.ITUNES_ENTITY_ALBUM
import dev.kawaiidevs.domain.constants.ITUNES_ENTITY_ATTRIBUTE
import dev.kawaiidevs.domain.model.SearchEntity
import dev.kawaiidevs.domain.repository.ItunesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ActivityScoped
class ItunesRepositoryImp @Inject constructor(
    private val api: Api
) : ItunesRepository {
    override suspend fun getItunesList(artistName: String): Flow<ResultItunes<SearchEntity>> =
        flow {
            emit(getItunesListHandleResultRetrofit(artistName))
        }

    private suspend fun getItunesListHandleResultRetrofit(artistName: String): ResultItunes<SearchEntity> {
        val result = executeRetrofitRequest {
            api.getItunesList(
                artistName,
                ITUNES_ENTITY_ALBUM,
                ITUNES_ENTITY_ATTRIBUTE,
                ITUNES_DEFAULT_LIMIT
            )
        }
        return handleResultRetrofit(result) { it.mapToDomain() }
    }

}
