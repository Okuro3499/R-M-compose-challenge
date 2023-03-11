package com.compose.rmcomposechallenge.presentation.characters

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.compose.rmcomposechallenge.R
import com.compose.rmcomposechallenge.Screens
import com.compose.rmcomposechallenge.domain.models.Result
import com.compose.rmcomposechallenge.ui.theme.BlackBackground

@Composable
fun HomeScreen(
    navController: NavController
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ) {

        val viewModel: CharactersViewModel = hiltViewModel()

        val state = viewModel.state.value



        LazyColumn {
            state.characters?.results?.let {
                items(it.size) {i ->
                    val character = it[i]
                    RickAndMortyCharacter(
                        character,
                        navController
                    )

                }
            }
        }
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RickAndMortyCharacter(character: Result, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10)),
        backgroundColor = Color.LightGray,
        elevation = 4.dp,
        onClick = {
            navController.navigate(Screens.CharacterDetailScreen.route + "/${character.id}")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            AsyncImage(
                model = character.image,
                contentDescription = "Character Image",
                modifier = Modifier.
                        height(150.dp)
            )

            Column (
                modifier = Modifier
                    .fillMaxHeight()
            ){
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp)
                )

                val statusStringStyle = listOf( AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start = 0,
                        end = 7
                        )
                    )
                val statusString = "Status: ${character.status}"
                Text(
                    text = AnnotatedString(text = statusString, spanStyles = statusStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                )

                val speciesStringStyle = listOf( AnnotatedString.Range(
                    SpanStyle(fontWeight = FontWeight.Bold),
                    start = 0,
                    end = 8
                )
                )
                val speciesString = "Species: ${character.species}"
                Text(
                    text = AnnotatedString(text = speciesString, spanStyles = speciesStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )

                val originStringStyle = listOf( AnnotatedString.Range(
                    SpanStyle(fontWeight = FontWeight.Bold),
                    start = 0,
                    end = 7
                )
                )
                val originString = "Origin: ${character.origin.name}"
                Text(
                    text = AnnotatedString(text = originString, spanStyles = originStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}
