package tech.fingercode.data.watchlist

import kotlinx.coroutines.flow.Flow
import tech.fingercode.data.watchlist.repository.WatchListDataFactory
import tech.fingercode.domain.watchlist.WatchListRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WatchListImpl @Inject constructor(private val watchListDataFactory: WatchListDataFactory): WatchListRepository {
    override suspend fun getWatchList(page: Int): Flow<String> {
        return watchListDataFactory.getWatchList()
    }
}