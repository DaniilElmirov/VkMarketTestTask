package com.elmirov.vkmarkettesttask.presentation.details

sealed interface DetailsCommand {

    data object Load : DetailsCommand
}