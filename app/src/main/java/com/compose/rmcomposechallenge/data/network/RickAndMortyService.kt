package com.compose.rmcomposechallenge.data.network

import com.compose.rmcomposechallenge.data.network.dto.CharactersDTO
import com.compose.rmcomposechallenge.data.network.dto.ResultDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharactersList():CharactersDTO

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): ResultDTO
}