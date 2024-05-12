package com.elmirov.vkmarkettesttask.data.network

import com.elmirov.vkmarkettesttask.data.model.AllPokemonsResponse
import com.elmirov.vkmarkettesttask.data.model.FullPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon?limit=40&offset=0")
    suspend fun getAll(): AllPokemonsResponse

    @GET("pokemon/{name}/")
    suspend fun getByName(@Path("name") name: String): FullPokemonResponse
}