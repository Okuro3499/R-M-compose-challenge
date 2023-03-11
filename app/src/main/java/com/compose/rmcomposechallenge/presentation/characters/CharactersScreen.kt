package com.compose.rmcomposechallenge.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.compose.rmcomposechallenge.R
import com.compose.rmcomposechallenge.Screens
import com.compose.rmcomposechallenge.domain.models.Result
import com.compose.rmcomposechallenge.ui.theme.BlackBackground

@Composable
fun CharactersScreen(
    navController: NavController
) {

    val viewModel: CharactersViewModel = hiltViewModel()
    val state = viewModel.state.value

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(BlackBackground)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = R.drawable.img,
                    contentDescription = "Logo Image",
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                )

                Text(
                    text = "Rick And Morty",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(
                        start = 10.dp, bottom = 8.dp
                    )
                )
                Text(
                    text = "About",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, bottom = 8.dp)
                )

                Text(
                    text = "Rick and Morty is an American adult animated science-fiction sitcom created by " +
                            "Justin Roiland and Dan Harmon for Cartoon Network's nighttime programming block " +
                            "Adult Swim. It is distributed internationally by Warner Bros. Television Distribution. " +
                            "The series follows the misadventures of Rick Sanchez, a cynical mad scientist, " +
                            "and his good-hearted but fretful grandson Morty Smith, who split their time " +
                            "between domestic life and interdimensional adventures that take place across an " +
                            "infinite number of realities, often traveling to other planets and dimensions " +
                            "through portals and on Rick's flying saucer. The general concept of Rick and " +
                            "Morty relies on two conflicting scenarios: domestic family drama, and an " +
                            "alcoholic grandfather dragging his grandson into hijinks.",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(
                        bottom = 8.dp,
                        start = 10.dp, end = 10.dp
                    )
                )

                Text(
                    text = "Characters",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(
                        start = 10.dp, bottom = 8.dp
                    )
                )
                LazyRow(
                    modifier = Modifier.padding(
                        bottom = 8.dp,
                        start = 10.dp, end = 10.dp
                    )
                ) {
                    state.characters?.results?.let {
                        items(it.size) { i ->
                            val character = it[i]
                            RickAndMortyRowCharacter(
                                character,
                                navController
                            )
                        }
                    }
                }
            }

        }
    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(BlackBackground),
//        contentAlignment = Alignment.Center
//    ) {
//        Box(modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)) {
//            Column {
//                AsyncImage(
//                    model = R.drawable.img,
//                    contentDescription = "Logo Image",
//                    alignment = Alignment.TopCenter,
//                    modifier = Modifier
//                        .height(140.dp)
//                        .fillMaxWidth()
//                )
//
//                Text(
//                    text = "Rick And Morty",
//                    style = MaterialTheme.typography.subtitle2
//                )
//                Text(
//                    text = "About",
//                    fontSize = 18.sp,
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//
//                Text(
//                    text = "Rick and Morty is an American adult animated science-fiction sitcom created by " +
//                            "Justin Roiland and Dan Harmon for Cartoon Network's nighttime programming block " +
//                            "Adult Swim. It is distributed internationally by Warner Bros. Television Distribution. " +
//                            "The series follows the misadventures of Rick Sanchez, a cynical mad scientist, " +
//                            "and his good-hearted but fretful grandson Morty Smith, who split their time " +
//                            "between domestic life and interdimensional adventures that take place across an " +
//                            "infinite number of realities, often traveling to other planets and dimensions " +
//                            "through portals and on Rick's flying saucer. The general concept of Rick and " +
//                            "Morty relies on two conflicting scenarios: domestic family drama, and an " +
//                            "alcoholic grandfather dragging his grandson into hijinks.",
//                    fontSize = 16.sp,
//                    color = Color.White,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//
//                Text(
//                    text = "Characters",
//                    style = MaterialTheme.typography.subtitle2
//                )
//                LazyRow {
//                    state.characters?.results?.let {
//                        items(it.size) {i ->
//                            val character = it[i]
//                            RickAndMortyRowCharacter(
//                                character,
//                                navController
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }

}

@Composable
fun RickAndMortyRowCharacter(character: Result, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable {
                navController.navigate(Screens.CharacterDetailScreen.route + "/${character.id}")
            }
    ) {
        Column {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .clip(RoundedCornerShape(15))
                    .height(150.dp)
            )

            Text(
                text = character.name,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )

            Text(
                text = character.status,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }
    }
}
