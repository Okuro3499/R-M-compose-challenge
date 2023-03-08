package com.compose.rmcomposechallenge.data.network.dto

import com.compose.rmcomposechallenge.domain.models.Characters
import com.compose.rmcomposechallenge.domain.models.Info

data class CharactersDTO(
    val info: Info,
    val results: List<ResultDTO>
)
{
    fun toCharacters(): Characters{
        return Characters(
            info = info,
            results = results.map { it.toResults() }
        )
    }
}