package com.elmirov.vkmarkettesttask.di.app.component

import com.elmirov.vkmarkettesttask.ui.activity.MainActivity
import com.elmirov.vkmarkettesttask.PokemonApplication
import com.elmirov.vkmarkettesttask.di.app.annotation.ApplicationScope
import com.elmirov.vkmarkettesttask.di.app.module.DataModule
import com.elmirov.vkmarkettesttask.di.app.module.DispatcherModule
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DispatcherModule::class,
        DataModule::class,
    ]
)
interface ApplicationComponent {
    fun inject(application: PokemonApplication)

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(): ApplicationComponent
    }
}