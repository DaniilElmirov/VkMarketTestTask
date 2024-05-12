package com.elmirov.vkmarkettesttask.navigation

import com.elmirov.vkmarkettesttask.ui.details.DetailsFragment
import com.elmirov.vkmarkettesttask.ui.pokemons.PokemonsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun PokemonsScreen(): FragmentScreen = FragmentScreen {
        PokemonsFragment.newInstance()
    }

    fun DetailsScreen(pokemonName: String): FragmentScreen = FragmentScreen {
        DetailsFragment.newInstance(pokemonName)
    }
}