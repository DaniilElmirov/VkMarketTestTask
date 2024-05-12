package com.elmirov.vkmarkettesttask.presentation.pokemons

import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.usecase.GetPokemonsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vivid.money.elmslie.core.store.Actor
import javax.inject.Inject

class PokemonsActor @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
) : Actor<PokemonsCommand, PokemonsEvent>() {
    override fun execute(command: PokemonsCommand): Flow<PokemonsEvent> = flow {
        when (val result = getPokemonsUseCase()) {
            is Result.Error -> emit(PokemonsEvent.Internal.PokemonsLoadingError)
            is Result.Success -> emit(PokemonsEvent.Internal.PokemonsLoadingSuccess(result.data))
        }
    }
}