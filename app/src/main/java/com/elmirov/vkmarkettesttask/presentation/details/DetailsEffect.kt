package com.elmirov.vkmarkettesttask.presentation.details

sealed interface DetailsEffect {

    data object ShowError : DetailsEffect
}