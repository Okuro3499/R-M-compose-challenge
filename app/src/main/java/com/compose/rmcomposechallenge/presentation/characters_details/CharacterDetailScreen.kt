package com.compose.rmcomposechallenge.presentation.characters_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.compose.rmcomposechallenge.ui.theme.BlackBackground

@Composable
fun CharacterDetailScreen( navController: NavController) {

    val viewModel: CharacterDetailViewModel = hiltViewModel()

    val state = viewModel.state.value

    Column(modifier = Modifier
        .fillMaxSize()
        .background(BlackBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
       val character= state.character
        if (character != null) {
            NavBar(
                title = stringResource(id = R.string.title),
                onBackPress = {
                    navController.navigateUp()
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = character.name,
                style = MaterialTheme.typography.h4,
                textAlign =  TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                model = character.image,
                contentDescription = "Character Image",
                Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            Column(Modifier
                .fillMaxSize()
                .padding(start = 8.dp))
            {
                val statusStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ), start = 0, end = 7)
                )
                val statusString = "Status: ${character.status}"
                Text(
                    text = AnnotatedString (text = statusString, spanStyles = statusStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp), color = Color.White
                )
                val speciesStringStyle = listOf(
                    AnnotatedString.Range(SpanStyle(fontWeight = FontWeight.Bold, color = Color.White),
                        start = 0, end = 8
                    ))
                val speciesString = "Species: ${character.species}"
                Text(
                    text = AnnotatedString(text = speciesString, spanStyles = speciesStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp), color = Color.White
                )

                val genderStringStyle = listOf(
                    AnnotatedString.Range(
                        SpanStyle(fontWeight = FontWeight.Bold, color = Color.White),
                        start = 0,
                        end = 8
                    ))
                val genderString = "Species: ${character.species}"
                Text(
                    text = AnnotatedString(text = genderString, spanStyles = genderStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp), color = Color.White
                )
                val originStringStyle = listOf( AnnotatedString.Range(
                    SpanStyle(fontWeight = FontWeight.Bold, color = Color.White), start = 0, end = 7)
                )
                val originString = "Origin: ${character.origin.name}"
                Text(
                    text = AnnotatedString(text = originString, spanStyles = originStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp), color = Color.White
                )
                val firstEpisodeStringStyle = listOf( AnnotatedString.Range(
                    SpanStyle(fontWeight = FontWeight.Bold, color = Color.White), start = 0, end = 13
                ))
                val firstEpisodeString = "First Episode: ${character.episode[0]}"
                Text(
                    text = AnnotatedString(text = firstEpisodeString, spanStyles = firstEpisodeStringStyle),
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp), color = Color.White
                )
            }
        }
    }
}

@Composable
fun NavBar(title:String, onBackPress:()-> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackPress()}) {
            Icon(painter = painterResource(id = R.drawable.backdraw), contentDescription = "")
        }
        Text(
            text = title,Modifier
                .padding(start = 75.dp),
            style = MaterialTheme.typography.subtitle2
        )
    }
}



