package dev.kawaiidevs.domain.usecases

import dagger.hilt.android.scopes.ActivityScoped
import dev.kawaiidevs.domain.ResultItunes
import dev.kawaiidevs.domain.model.SearchEntity
import dev.kawaiidevs.domain.repository.ItunesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScoped
class ItunesUseCaseImpl @Inject constructor(
    private val repository: ItunesRepository
) : ItunesUseCase {

    override suspend fun getItunesList(artistName: String): Flow<ResultItunes<SearchEntity>> {
        return repository.getItunesList(artistName)
    }
}