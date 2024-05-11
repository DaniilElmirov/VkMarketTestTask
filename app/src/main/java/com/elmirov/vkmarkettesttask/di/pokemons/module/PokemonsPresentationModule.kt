package com.elmirov.vkmarkettesttask.di.pokemons.module

import com.elmirov.vkmarkettesttask.di.pokemons.annotation.PokemonsScope
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsActor
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsCommand
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsEffect
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsEvent
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsReducer
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsState
import dagger.Module
import dagger.Provides
import vivid.money.elmslie.core.store.ElmStore

@Module
class PokemonsPresentationModule {
    @Provides
    @PokemonsScope
    fun providePokemonsState(): PokemonsState = PokemonsState()

    @Provides
    @PokemonsScope
    fun providePokemonsStore(
        pokemonsState: PokemonsState,
        pokemonsReducer: PokemonsReducer,
        pokemonsActor: PokemonsActor
    ): ElmStore<PokemonsEvent, PokemonsState, PokemonsEffect, PokemonsCommand> =
        ElmStore(
            initialState = pokemonsState,
            reducer = pokemonsReducer,
            actor = pokemonsActor,
        )
}