package com.compose.rmcomposechallenge.presentation.characters_details

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterDetailScreen() {
    val viewModel: CharacterDetailViewModel = hiltViewModel()

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    )
}