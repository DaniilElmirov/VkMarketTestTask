package com.elmirov.vkmarkettesttask.di.component

import com.elmirov.vkmarkettesttask.MainActivity
import com.elmirov.vkmarkettesttask.PokemonApplication
import com.elmirov.vkmarkettesttask.di.annotation.ApplicationScope
import com.elmirov.vkmarkettesttask.di.module.DataModule
import dagger.Component

@ApplicationScope
@Component(
    modules = [
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