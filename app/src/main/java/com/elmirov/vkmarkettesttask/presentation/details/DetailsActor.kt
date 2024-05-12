package com.elmirov.vkmarkettesttask.presentation.details

import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.usecase.GetPokemonDetailsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vivid.money.elmslie.core.store.Actor
import javax.inject.Inject

class DetailsActor @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val pokemonName: String,
) : Actor<DetailsCommand, DetailsEvent>() {
    override fun execute(command: DetailsCommand): Flow<DetailsEvent> = flow {
        when (command) {

            is DetailsCommand.Load -> {
                when (val result = getPokemonDetailsUseCase(pokemonName)) {
                    is Result.Error -> emit(DetailsEvent.Internal.DetailsLoadingError)
                    is Result.Success -> emit(DetailsEvent.Internal.DetailsLoadingSuccess(result.data))
                }
            }
        }
    }
}