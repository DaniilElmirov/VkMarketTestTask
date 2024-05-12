package com.elmirov.vkmarkettesttask.data.mapper

import com.elmirov.vkmarkettesttask.data.model.AllPokemonsResponse
import com.elmirov.vkmarkettesttask.data.model.FullPokemonResponse
import com.elmirov.vkmarkettesttask.data.model.PartialPokemonDao
import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

private const val IMAGE_URL_FORMAT =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%s"

fun AllPokemonsResponse.toEntities(): List<PartialPokemon> = results.map { it.toEntity() }

private fun PartialPokemonDao.toEntity(): PartialPokemon {
    val regex = Regex("mon/(\\d+)/")
    val id = regex.find(url)?.groupValues?.get(1)

    var imageUrl: String? = null

    if (id != null)
        imageUrl = String.format(IMAGE_URL_FORMAT, "$id.png")

    return PartialPokemon(
        imageUrl = imageUrl,
        name = name,
    )
}

fun FullPokemonResponse.toEntity(): FullPokemon {
    val imageUrl = String.format(IMAGE_URL_FORMAT, "$id.png")

    return FullPokemon(
        imageUrl = imageUrl,
        name = name,
        height = height,
        weight = weight,
        reward = reward,
    )
}