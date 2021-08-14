package tech.fingercode.data.service

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getWatchList(): Flow<String>
}