package com.elmirov.vkmarkettesttask.presentation.pokemons

import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

sealed interface PokemonsEvent {

    sealed interface Ui : PokemonsEvent {
        data object Init : Ui

        data object OnRefreshClick : Ui
    }

    sealed interface Internal : PokemonsEvent {
        data class PokemonsLoadingSuccess(val data: List<PartialPokemon>) : Internal

        data object PokemonsLoadingError : Internal
    }
}