package com.elmirov.vkmarkettesttask.presentation.details

import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon

data class DetailsState(
    val loading: Boolean = true,
    val content: FullPokemon? = null,
)
