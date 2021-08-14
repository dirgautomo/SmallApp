package tech.fingercode.data.watchlist.repository

import kotlinx.coroutines.flow.Flow
import tech.fingercode.data.service.ApiService
import javax.inject.Inject

class WatchListDataFactory @Inject constructor(private val apiService: ApiService) :
    WatchListDataRepository {
    override suspend fun getWatchList(): Flow<String> {
        return apiService.getWatchList()
    }

}