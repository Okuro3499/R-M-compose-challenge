package com.compose.rmcomposechallenge.presentation.characters_details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.compose.rmcomposechallenge.R
import com.compose.rmcomposechallenge.ui.theme.BlackBackground

@Composable
fun CharacterDetailScreen(character:Result) {
    val viewModel: CharacterDetailViewModel = hiltViewModel()

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ){

    }

}



