package tech.fingercode.smallapp.di

import android.app.Application
import dagger.Component
import tech.fingercode.data.service.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class
    ]
)

interface AppComponent {
    fun inject(application: Application)
}