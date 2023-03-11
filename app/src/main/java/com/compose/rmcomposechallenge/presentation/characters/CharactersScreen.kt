package com.compose.rmcomposechallenge.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.compose.rmcomposechallenge.Screens
import com.compose.rmcomposechallenge.domain.models.Result
import com.compose.rmcomposechallenge.ui.theme.BlackBackground
import com.compose.rmcomposechallenge.R

@Composable
fun CharactersScreen(
    navController: NavController
){

    val viewModel: CharactersViewModel = hiltViewModel()

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            Column {

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
                    style = MaterialTheme.typography.subtitle2
                )
                Text(
                    text = "About",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Text(
                    text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia, molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam nihil, eveniet aliquid culpa officia aut! ",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Characters",
                    style = MaterialTheme.typography.subtitle2
                )
                LazyRow {
                    state.characters?.results?.let {
                        items(it.size) {i ->
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
