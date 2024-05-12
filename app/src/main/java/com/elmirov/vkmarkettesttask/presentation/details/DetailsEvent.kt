package com.elmirov.vkmarkettesttask.presentation.details

import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon

sealed interface DetailsEvent {

    sealed interface Ui : DetailsEvent {
        data object Init : Ui

        data object OnRefreshClick : Ui

        data object OnBackClick : Ui
    }

    sealed interface Internal : DetailsEvent {
        data class DetailsLoadingSuccess(val data: FullPokemon) : Internal

        data object DetailsLoadingError : Internal
    }
}