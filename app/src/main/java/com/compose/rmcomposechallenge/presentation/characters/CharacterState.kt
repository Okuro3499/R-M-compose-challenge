package com.compose.rmcomposechallenge.presentation.characters

import com.compose.rmcomposechallenge.domain.models.Characters

data class CharacterState(
    val characters: Characters? = null,
    val error: String? = null
)
