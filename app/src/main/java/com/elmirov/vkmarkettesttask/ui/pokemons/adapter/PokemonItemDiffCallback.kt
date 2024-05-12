package com.elmirov.vkmarkettesttask.ui.pokemons.adapter

import androidx.recyclerview.widget.DiffUtil
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

class PokemonItemDiffCallback : DiffUtil.ItemCallback<PartialPokemon>() {
    override fun areItemsTheSame(oldItem: PartialPokemon, newItem: PartialPokemon): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PartialPokemon, newItem: PartialPokemon): Boolean =
        oldItem == newItem
}