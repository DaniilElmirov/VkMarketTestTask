package com.elmirov.vkmarkettesttask.presentation.details

import vivid.money.elmslie.core.store.dsl.ScreenDslReducer
import javax.inject.Inject

class DetailsReducer @Inject constructor() : ScreenDslReducer<
        DetailsEvent,
        DetailsEvent.Ui,
        DetailsEvent.Internal,
        DetailsState,
        DetailsEffect,
        DetailsCommand>(
    DetailsEvent.Ui::class, DetailsEvent.Internal::class
) {
    override fun Result.internal(event: DetailsEvent.Internal): Any = when (event) {
        DetailsEvent.Internal.DetailsLoadingError -> {
            state { copy(loading = false) }
            effects { +DetailsEffect.ShowError }
        }

        is DetailsEvent.Internal.DetailsLoadingSuccess -> {
            state { copy(loading = false, content = event.data) }
        }
    }

    override fun Result.ui(event: DetailsEvent.Ui): Any = when (event) {
        DetailsEvent.Ui.Init -> {
            state { copy(loading = true) }
            commands { +DetailsCommand.Load }
        }

        DetailsEvent.Ui.OnRefreshClick -> {
            state { copy(loading = true) }
            commands { +DetailsCommand.Load }
        }
    }
}