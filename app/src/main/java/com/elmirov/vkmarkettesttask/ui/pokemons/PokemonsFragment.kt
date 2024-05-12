package com.elmirov.vkmarkettesttask.ui.pokemons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.elmirov.vkmarkettesttask.PokemonApplication
import com.elmirov.vkmarkettesttask.R
import com.elmirov.vkmarkettesttask.databinding.FragmentPokemonsBinding
import com.elmirov.vkmarkettesttask.domain.entity.PartialPokemon
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsCommand
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsEffect
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsEvent
import com.elmirov.vkmarkettesttask.presentation.pokemons.PokemonsState
import com.elmirov.vkmarkettesttask.ui.base.ElmBaseFragment
import com.elmirov.vkmarkettesttask.ui.pokemons.adapter.PokemonAdapter
import vivid.money.elmslie.android.renderer.elmStoreWithRenderer
import vivid.money.elmslie.core.store.ElmStore
import vivid.money.elmslie.core.store.Store
import javax.inject.Inject

class PokemonsFragment : ElmBaseFragment<PokemonsEffect, PokemonsState, PokemonsEvent>() {

    companion object {
        fun newInstance(): PokemonsFragment = PokemonsFragment()
    }

    private var _binding: FragmentPokemonsBinding? = null
    private val binding
        get() = _binding!!

    private val component by lazy {
        (requireActivity().application as PokemonApplication).component.pokemonsComponentFactory()
            .create()
    }

    @Inject
    lateinit var pokemonsStore: ElmStore<PokemonsEvent, PokemonsState, PokemonsEffect, PokemonsCommand>

    override val store: Store<PokemonsEvent, PokemonsEffect, PokemonsState> by elmStoreWithRenderer(
        elmRenderer = this
    ) {
        pokemonsStore
    }

    private val pokemonAdapter: PokemonAdapter by lazy {
        PokemonAdapter(
            onPokemonClick = {
                store.accept(PokemonsEvent.Ui.OnPokemonClick(it))
            }
        )
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemons.adapter = pokemonAdapter
        store.accept(PokemonsEvent.Ui.Init)
        setupListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setupListeners() {
        binding.refresh.setOnClickListener {
            store.accept(PokemonsEvent.Ui.OnRefreshClick)
        }
    }

    override fun render(state: PokemonsState) {
        if (state.loading)
            applyLoading()

        state.content?.let {
            applyContent(it)
        }
    }

    override fun handleEffect(effect: PokemonsEffect): Unit = when (effect) {
        PokemonsEffect.ShowError -> applyError()
    }

    private fun applyLoading() {
        binding.apply {
            error.isVisible = false
            toolbar.isVisible = true

            pokemons.isVisible = false

            shimmer.isVisible = true
            shimmer.startShimmer()
        }
    }

    private fun applyContent(content: List<PartialPokemon>) {
        binding.apply {
            error.isVisible = false
            toolbar.isVisible = true

            pokemons.isVisible = true

            shimmer.isVisible = false
            shimmer.stopShimmer()
        }

        pokemonAdapter.submitList(content)
    }

    private fun applyError() {
        binding.apply {
            error.isVisible = true
            errorMessage.text = getString(R.string.unknown_error)

            toolbar.isVisible = true

            pokemons.isVisible = false

            shimmer.isVisible = false
            shimmer.stopShimmer()
        }
    }
}