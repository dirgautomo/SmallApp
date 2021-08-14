package tech.fingercode.smallapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import tech.fingercode.domain.watchlist.interactor.WatchListInteractor
import tech.fingercode.smallapp.utils.Resource
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    @Inject
    lateinit var watchListInteractor: WatchListInteractor

    fun getWatchList(page: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = watchListInteractor.execute(page)))
        } catch (exception: Exception) {
            emit(Resource.error(exception, exception.message ?: ""))
        }
    }

}