package tech.fingercode.smallapp

import android.app.Application
import tech.fingercode.data.service.NetworkModule
import tech.fingercode.smallapp.di.AppComponent
import tech.fingercode.smallapp.di.AppModule
import tech.fingercode.smallapp.di.DaggerAppComponent

class SmallAppApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
        this.appComponent.inject(this)
    }

    private fun initDagger() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .networkModule(NetworkModule())
        .build()

    fun getApplicationComponent(): AppComponent {
        return appComponent
    }
}