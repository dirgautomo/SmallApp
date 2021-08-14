package tech.fingercode.domain.watchlist

import kotlinx.coroutines.flow.Flow


interface WatchListRepository {
    suspend fun getWatchList(page:Int): Flow<String>
}