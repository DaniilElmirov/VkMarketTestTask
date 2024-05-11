package com.elmirov.vkmarkettesttask.data.repository

import com.elmirov.vkmarkettesttask.data.mapper.toEntities
import com.elmirov.vkmarkettesttask.data.network.PokemonApi
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.repository.PokemonRepository
import com.elmirov.vkmarkettesttask.util.getResultWithHandleError
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
) : PokemonRepository {

    override suspend fun getAll(): Result<List<PartialPokemon>> = getResultWithHandleError(
        dispatcher = Dispatchers.IO,
        data = {
            api.getAll().toEntities()
        }
    )
}