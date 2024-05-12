package com.elmirov.vkmarkettesttask.di.details.component

import com.elmirov.vkmarkettesttask.di.details.annotation.DetailsScope
import com.elmirov.vkmarkettesttask.di.details.module.DetailsPresentationModule
import com.elmirov.vkmarkettesttask.ui.details.DetailsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@DetailsScope
@Subcomponent(
    modules = [
        DetailsPresentationModule::class,
    ]
)
interface DetailsComponent {

    fun inject(fragment: DetailsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance pokemonName: String): DetailsComponent
    }
}