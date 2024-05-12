package com.elmirov.vkmarkettesttask.di.details.module

import com.elmirov.vkmarkettesttask.di.details.annotation.DetailsScope
import com.elmirov.vkmarkettesttask.presentation.details.DetailsActor
import com.elmirov.vkmarkettesttask.presentation.details.DetailsCommand
import com.elmirov.vkmarkettesttask.presentation.details.DetailsEffect
import com.elmirov.vkmarkettesttask.presentation.details.DetailsEvent
import com.elmirov.vkmarkettesttask.presentation.details.DetailsReducer
import com.elmirov.vkmarkettesttask.presentation.details.DetailsState
import dagger.Module
import dagger.Provides
import vivid.money.elmslie.core.store.ElmStore

@Module
class DetailsPresentationModule {
    @Provides
    @DetailsScope
    fun provideDetailsState(): DetailsState = DetailsState()

    @Provides
    @DetailsScope
    fun provideDetailsStore(
        detailsState: DetailsState,
        detailsReducer: DetailsReducer,
        detailsActor: DetailsActor
    ): ElmStore<DetailsEvent, DetailsState, DetailsEffect, DetailsCommand> =
        ElmStore(
            initialState = detailsState,
            reducer = detailsReducer,
            actor = detailsActor,
        )
}