package com.compose.rmcomposechallenge.domain.usecases

import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.domain.repository.RickAndMortyRepository
import com.compose.rmcomposechallenge.domain.models.Result
import kotlinx.coroutines.flow.Flow

class GetCharacterDetails(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(id: Int): Flow<ResultWrapper<Result>> {
        return  repository.getCharacterDetails(id)
    }
}