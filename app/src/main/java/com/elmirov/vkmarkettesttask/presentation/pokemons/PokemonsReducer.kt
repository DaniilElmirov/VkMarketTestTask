package com.elmirov.vkmarkettesttask.presentation.pokemons

import vivid.money.elmslie.core.store.dsl.ScreenDslReducer
import javax.inject.Inject

class PokemonsReducer @Inject constructor() : ScreenDslReducer<
        PokemonsEvent,
        PokemonsEvent.Ui,
        PokemonsEvent.Internal,
        PokemonsState,
        PokemonsEffect,
        PokemonsCommand>(
    PokemonsEvent.Ui::class, PokemonsEvent.Internal::class
) {
    override fun Result.internal(event: PokemonsEvent.Internal): Any = when (event) {
        PokemonsEvent.Internal.PokemonsLoadingError -> {
            state { copy(loading = false) }
            effects { +PokemonsEffect.ShowError }
        }

        is PokemonsEvent.Internal.PokemonsLoadingSuccess -> {
            state { copy(loading = false, content = event.data) }
        }
    }

    override fun Result.ui(event: PokemonsEvent.Ui): Any = when (event) {
        PokemonsEvent.Ui.Init -> {
            state { copy(loading = true) }
            commands { +PokemonsCommand.Load }
        }

        PokemonsEvent.Ui.OnRefreshClick -> {
            state { copy(loading = true) }
            commands { +PokemonsCommand.Load }
        }
    }
}