package com.elmirov.vkmarkettesttask.data.model

import com.google.gson.annotations.SerializedName

data class FullPokemonResponse(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @SerializedName("base_experience") val reward: Int,
)