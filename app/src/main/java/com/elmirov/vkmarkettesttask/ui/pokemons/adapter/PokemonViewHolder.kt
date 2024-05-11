package com.elmirov.vkmarkettesttask.ui.pokemons.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.elmirov.vkmarkettesttask.R
import com.elmirov.vkmarkettesttask.databinding.PokemonItemBinding
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon

class PokemonViewHolder(
    parent: ViewGroup,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
) {

    private val binding = PokemonItemBinding.bind(itemView)

    fun bind(partialPokemon: PartialPokemon) {
        binding.image.load(partialPokemon.imageUrl) {
            error(R.drawable.ic_launcher_foreground)
            transformations(CircleCropTransformation())
        }

        binding.name.text = partialPokemon.name.replaceFirstChar { it.uppercase() }
    }
}