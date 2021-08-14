package tech.fingercode.domain.watchlist.interactor

import kotlinx.coroutines.flow.Flow
import tech.fingercode.domain.watchlist.WatchListRepository
import javax.inject.Inject


internal interface GetWatchListUseCase {
    suspend fun execute(page: Int): Flow<String>
}

class WatchListInteractor @Inject constructor(private val watchListRepository: WatchListRepository) :
    GetWatchListUseCase {
    override suspend fun execute(page: Int): Flow<String> {
        return watchListRepository.getWatchList(page)
    }
}