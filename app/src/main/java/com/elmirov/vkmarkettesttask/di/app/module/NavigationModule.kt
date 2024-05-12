package com.elmirov.vkmarkettesttask.di.app.module

import com.elmirov.vkmarkettesttask.di.app.annotation.ApplicationScope
import com.elmirov.vkmarkettesttask.navigation.PokemonRouter
import com.elmirov.vkmarkettesttask.navigation.PokemonRouterImpl
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        NavigationBindModule::class,
    ]
)
class NavigationModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @ApplicationScope
    fun provideRouter(): Router = cicerone.router

    @Provides
    @ApplicationScope
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()
}

@Module
interface NavigationBindModule {

    @Binds
    @ApplicationScope
    fun bindPokemonRouter(impl: PokemonRouterImpl): PokemonRouter
}