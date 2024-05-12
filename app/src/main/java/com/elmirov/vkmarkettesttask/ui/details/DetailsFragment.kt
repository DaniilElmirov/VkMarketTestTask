package com.elmirov.vkmarkettesttask.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import coil.load
import coil.transform.CircleCropTransformation
import com.elmirov.vkmarkettesttask.PokemonApplication
import com.elmirov.vkmarkettesttask.R
import com.elmirov.vkmarkettesttask.databinding.FragmentDetailsBinding
import com.elmirov.vkmarkettesttask.domain.entity.FullPokemon
import com.elmirov.vkmarkettesttask.presentation.details.DetailsCommand
import com.elmirov.vkmarkettesttask.presentation.details.DetailsEffect
import com.elmirov.vkmarkettesttask.presentation.details.DetailsEvent
import com.elmirov.vkmarkettesttask.presentation.details.DetailsState
import com.elmirov.vkmarkettesttask.ui.base.ElmBaseFragment
import vivid.money.elmslie.android.renderer.elmStoreWithRenderer
import vivid.money.elmslie.core.store.ElmStore
import vivid.money.elmslie.core.store.Store
import javax.inject.Inject

class DetailsFragment : ElmBaseFragment<DetailsEffect, DetailsState, DetailsEvent>() {

    companion object {
        private const val KEY_POKEMON_NAME = "KEY_POKEMON_NAME"
        private const val DEFAULT_POKEMON_NAME = "bulbasaur"

        fun newInstance(pokemonName: String): DetailsFragment =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_POKEMON_NAME, pokemonName)
                }
            }
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!

    private val component by lazy {
        val pokemonName = arguments?.getString(KEY_POKEMON_NAME) ?: DEFAULT_POKEMON_NAME

        (requireActivity().application as PokemonApplication).component.detailsComponentFactory()
            .create(pokemonName)
    }

    @Inject
    lateinit var detailsStore: ElmStore<DetailsEvent, DetailsState, DetailsEffect, DetailsCommand>

    override val store: Store<DetailsEvent, DetailsEffect, DetailsState> by elmStoreWithRenderer(
        elmRenderer = this
    ) {
        detailsStore
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
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        store.accept(DetailsEvent.Ui.Init)
        setupListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setupListeners() {
        binding.refresh.setOnClickListener {
            store.accept(DetailsEvent.Ui.OnRefreshClick)
        }

        binding.toolbar.setNavigationOnClickListener {
            store.accept(DetailsEvent.Ui.OnBackClick)
        }
    }

    override fun render(state: DetailsState) {
        if (state.loading)
            applyLoading()

        state.content?.let {
            applyContent(it)
        }
    }

    override fun handleEffect(effect: DetailsEffect): Unit = when (effect) {
        DetailsEffect.ShowError -> applyError()
    }

    private fun applyLoading() {
        binding.apply {
            error.isVisible = false
            toolbar.isVisible = true

            image.isVisible = false
            name.isVisible = false
            height.isVisible = false
            weight.isVisible = false
            reward.isVisible = false

            shimmer.isVisible = true
            shimmer.startShimmer()
        }
    }

    private fun applyContent(content: FullPokemon) {
        binding.apply {
            error.isVisible = false
            toolbar.isVisible = true

            image.isVisible = true
            name.isVisible = true
            height.isVisible = true
            weight.isVisible = true
            reward.isVisible = true

            shimmer.isVisible = false
            shimmer.stopShimmer()

            image.load(content.imageUrl) {
                error(R.drawable.ic_launcher_foreground)
                transformations(CircleCropTransformation())
            }
            name.text = content.name.uppercase()
            height.text = String.format(getString(R.string.height_with_value), content.height)
            weight.text = String.format(getString(R.string.weight_with_value), content.weight)
            reward.text = String.format(getString(R.string.reward_with_value), content.reward)
        }
    }

    private fun applyError() {
        binding.apply {
            error.isVisible = true
            errorMessage.text = getString(R.string.unknown_error)

            toolbar.isVisible = true

            image.isVisible = false
            name.isVisible = false
            height.isVisible = false
            weight.isVisible = false
            reward.isVisible = false

            shimmer.isVisible = false
            shimmer.stopShimmer()
        }
    }
}