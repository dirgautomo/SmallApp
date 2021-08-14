package tech.fingercode.smallapp.ui.home.di

import dagger.Component
import tech.fingercode.data.service.WatchListModule
import tech.fingercode.smallapp.di.AppComponent
import tech.fingercode.smallapp.ui.home.HomeFragment

@PerFragment
@Component(
    dependencies = [AppComponent::class],
    modules = [WatchListModule::class]
)

interface HomeFragmentComponent {
    fun inject(homeFragment: HomeFragment)
}