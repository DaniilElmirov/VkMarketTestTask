package com.elmirov.vkmarkettesttask.di.module

import com.elmirov.vkmarkettesttask.data.network.PokemonApi
import com.elmirov.vkmarkettesttask.data.repository.PokemonRepositoryImpl
import com.elmirov.vkmarkettesttask.di.annotation.ApplicationScope
import com.elmirov.vkmarkettesttask.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module(includes = [BindDataModule::class])
class DataModule {

    private companion object {

        private const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @Provides
    @ApplicationScope
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    @Provides
    @ApplicationScope
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @ApplicationScope
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create()
}

@Module
interface BindDataModule {

    @Binds
    @ApplicationScope
    fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}