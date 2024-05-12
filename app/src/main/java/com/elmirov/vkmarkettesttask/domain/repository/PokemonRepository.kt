package com.elmirov.vkmarkettesttask.domain.repository

import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result

interface PokemonRepository {

    suspend fun getAll(): Result<List<PartialPokemon>>

    suspend fun getDetailsByName(name: String): Result<FullPokemon>
}