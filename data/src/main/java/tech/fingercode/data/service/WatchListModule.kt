package tech.fingercode.data.service

import dagger.Module
import dagger.Provides
import tech.fingercode.data.watchlist.repository.WatchListDataFactory
import tech.fingercode.data.watchlist.repository.WatchListDataRepository
import tech.fingercode.domain.watchlist.WatchListRepository
import tech.fingercode.domain.watchlist.interactor.WatchListInteractor

@Module
class WatchListModule {

    @Provides
    fun provideApiDataSource(apiService: ApiService): WatchListDataRepository {
        return WatchListDataFactory(apiService)
    }

    @Provides
    fun provideWatchListInteractor(watchListRepository: WatchListRepository): WatchListInteractor {
        return WatchListInteractor(watchListRepository)
    }
}