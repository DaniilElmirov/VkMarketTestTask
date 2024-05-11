package com.elmirov.vkmarkettesttask.data.repository

import com.elmirov.vkmarkettesttask.data.mapper.toEntities
import com.elmirov.vkmarkettesttask.data.network.PokemonApi
import com.elmirov.vkmarkettesttask.di.app.annotation.DispatcherIo
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.repository.PokemonRepository
import com.elmirov.vkmarkettesttask.util.getResultWithHandleError
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    @DispatcherIo private val dispatcherIo: CoroutineDispatcher,
) : PokemonRepository {

    override suspend fun getAll(): Result<List<PartialPokemon>> = getResultWithHandleError(
        dispatcher = dispatcherIo,
        data = {
            api.getAll().toEntities()
        }
    )
}