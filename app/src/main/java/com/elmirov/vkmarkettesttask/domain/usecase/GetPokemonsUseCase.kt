package com.elmirov.vkmarkettesttask.domain.usecase

import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
) : suspend () -> Result<List<PartialPokemon>> by repository::getAll