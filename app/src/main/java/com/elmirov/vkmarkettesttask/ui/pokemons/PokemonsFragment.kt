package com.elmirov.vkmarkettesttask.ui.pokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elmirov.vkmarkettesttask.databinding.FragmentPokemonsBinding

class PokemonsFragment: Fragment() {

    private var _binding: FragmentPokemonsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        return binding.root
    }
}