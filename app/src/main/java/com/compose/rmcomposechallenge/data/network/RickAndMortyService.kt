package com.compose.rmcomposechallenge.data.network

import com.compose.rmcomposechallenge.data.network.dto.CharactersDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharactersList():CharactersDTO

}