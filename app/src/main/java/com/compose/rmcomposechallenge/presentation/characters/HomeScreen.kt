package com.compose.rmcomposechallenge.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.compose.rmcomposechallenge.domain.models.Result
import com.compose.rmcomposechallenge.ui.theme.BlackBackground

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground)
            .padding(top = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val viewModel: CharactersViewModel = hiltViewModel()
        val state = viewModel.state.value
        LazyColumn {
            state.characters?.results?.let {
                items(it.size) { i ->
                    val character = it[i]
                    RickAndMortyCharacter(character)
                }
            }
        }
    }
}

@Composable
fun RickAndMortyCharacter(character: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(10)),
        backgroundColor = Color.LightGray,
        elevation = 4.dp,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = "Character Image",
                modifier = Modifier.height(150.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp)
                )

                val statusStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black),
                        start = 0,
                        end = 7
                    )
                )
                val statusString = "Status: ${character.status}"
                Text(
                    text = AnnotatedString(text = statusString, spanStyles = statusStringStyle,),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                )

                val speciesStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black),
                        start = 0,
                        end = 8
                    )
                )
                val speciesString = "Species: ${character.species}"
                Text(
                    text = AnnotatedString(text = speciesString, spanStyles = speciesStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )

                val originStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black),
                        start = 0,
                        end = 7
                    )
                )
                val originString = "Origin: ${character.origin.name}"
                Text(
                    text = AnnotatedString(text = originString, spanStyles = originStringStyle),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}

@Composable
fun RickAndMortyCharacterHome(character: Result) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .clickable { character },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(10)),
            model = character.image,
            contentDescription = "Character Image",
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp)
                    .width(IntrinsicSize.Min)
            )

            val statusStringStyle = listOf(
                AnnotatedString.Range(
                    SpanStyle(fontWeight = FontWeight.Bold),
                    start = 0,
                    end = 7
                )
            )
            val statusString = "Status: ${character.status}"
            Text(
                text = AnnotatedString(text = statusString, spanStyles = statusStringStyle),
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }
    }
}
