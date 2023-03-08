package com.compose.rmcomposechallenge.domain.repository

import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.domain.models.Characters
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllCharacters(): Flow<ResultWrapper<Characters>>
}