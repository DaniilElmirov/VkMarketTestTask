package com.elmirov.vkmarkettesttask.data.network

import com.elmirov.vkmarkettesttask.data.model.AllPokemonsResponse
import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon?limit=10&offset=0")
    suspend fun getAll(): AllPokemonsResponse
}