package com.elmirov.vkmarkettesttask.di.app.module

import com.elmirov.vkmarkettesttask.di.app.annotation.ApplicationScope
import com.elmirov.vkmarkettesttask.di.app.annotation.DispatcherIo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatcherModule {

    @Provides
    @ApplicationScope
    @DispatcherIo
    fun provideDispatcherIo(): CoroutineDispatcher = Dispatchers.IO
}