package com.elmirov.vkmarkettesttask.domain.repository

import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result

interface PokemonRepository {

    suspend fun getAll(): Result<List<PartialPokemon>>
}