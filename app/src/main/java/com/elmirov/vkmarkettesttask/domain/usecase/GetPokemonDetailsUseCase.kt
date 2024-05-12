package com.elmirov.vkmarkettesttask.domain.usecase

import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon
import com.elmirov.vkmarkettesttask.domain.entity.Result
import com.elmirov.vkmarkettesttask.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(
    private val repository: PokemonRepository,
) : suspend (String) -> Result<FullPokemon> by repository::getDetailsByName