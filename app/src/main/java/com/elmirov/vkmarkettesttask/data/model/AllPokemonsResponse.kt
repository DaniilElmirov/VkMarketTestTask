package com.elmirov.vkmarkettesttask.data.model

data class AllPokemonsResponse(
    val previous: String?,
    val next: String?,
    val results: List<PartialPokemonDao>,
)
