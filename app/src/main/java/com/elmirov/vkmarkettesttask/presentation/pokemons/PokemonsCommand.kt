package com.elmirov.vkmarkettesttask.presentation.pokemons

sealed interface PokemonsCommand {

    data object Load : PokemonsCommand
}