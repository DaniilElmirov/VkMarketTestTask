package com.elmirov.vkmarkettesttask.di.pokemons.component

import com.elmirov.vkmarkettesttask.di.pokemons.annotation.PokemonsScope
import com.elmirov.vkmarkettesttask.di.pokemons.module.PokemonsPresentationModule
import com.elmirov.vkmarkettesttask.ui.pokemons.PokemonsFragment
import dagger.Subcomponent

@PokemonsScope
@Subcomponent(
    modules = [
        PokemonsPresentationModule::class,
    ]
)
interface PokemonsComponent {

    fun inject(fragment: PokemonsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PokemonsComponent
    }
}