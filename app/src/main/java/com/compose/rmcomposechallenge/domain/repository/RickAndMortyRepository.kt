package com.compose.rmcomposechallenge.domain.repository

import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.domain.models.Characters
import com.compose.rmcomposechallenge.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllCharacters(): Flow<ResultWrapper<Characters>>

    fun getCharacterDetails(id: Int): Flow<ResultWrapper<Result>>
}