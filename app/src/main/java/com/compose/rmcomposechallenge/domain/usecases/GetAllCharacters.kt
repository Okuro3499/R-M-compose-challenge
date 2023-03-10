package com.compose.rmcomposechallenge.domain.usecases

import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.domain.models.Characters
import com.compose.rmcomposechallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacters(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(): Flow<ResultWrapper<Characters>>{
        return repository.getAllCharacters()
    }
}