package com.elmirov.vkmarkettesttask

import android.app.Application
import com.elmirov.vkmarkettesttask.di.app.component.DaggerApplicationComponent

class PokemonApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create()
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}