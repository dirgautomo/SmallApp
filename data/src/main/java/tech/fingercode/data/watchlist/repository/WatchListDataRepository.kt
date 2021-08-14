package tech.fingercode.data.watchlist.repository

import kotlinx.coroutines.flow.Flow


interface WatchListDataRepository {
    suspend fun getWatchList(): Flow<String>
}