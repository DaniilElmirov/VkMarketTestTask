package com.elmirov.vkmarkettesttask.navigation

import com.elmirov.vkmarkettesttask.navigation.Screens.DetailsScreen
import com.elmirov.vkmarkettesttask.navigation.Screens.PokemonsScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

interface PokemonRouter {
    fun openPokemons()

    fun openDetails(pokemonName: String)

    fun back()
}

class PokemonRouterImpl @Inject constructor(
    private val router: Router,
) : PokemonRouter {
    override fun openPokemons() {
        router.navigateTo(PokemonsScreen())
    }

    override fun openDetails(pokemonName: String) {
        router.navigateTo(DetailsScreen(pokemonName))
    }

    override fun back() {
        router.exit()
    }
}