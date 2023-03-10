package com.compose.rmcomposechallenge.presentation.characters_details

import com.compose.rmcomposechallenge.domain.models.Result

data class CharacterDetailState(
    val character: Result? = null,
    val error: String? = null
)
