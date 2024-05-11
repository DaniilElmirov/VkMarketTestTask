package com.elmirov.vkmarkettesttask.presentation.pokemons

sealed interface PokemonsEffect {

    data object ShowError : PokemonsEffect
}