package com.elmirov.vkmarkettesttask.ui.pokemons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

class PokemonAdapter : ListAdapter<PartialPokemon, PokemonViewHolder>(PokemonItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(parent)

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}