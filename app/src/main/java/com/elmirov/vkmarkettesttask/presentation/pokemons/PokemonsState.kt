package com.elmirov.vkmarkettesttask.presentation.pokemons

import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

data class PokemonsState(
    val loading: Boolean = true,
    val content: List<PartialPokemon>? = null,
)
