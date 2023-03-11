package com.compose.rmcomposechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.rmcomposechallenge.presentation.characters.CharactersViewModel
import com.compose.rmcomposechallenge.presentation.characters.HomeScreen
import com.compose.rmcomposechallenge.presentation.characters.RickAndMortyCharacterHome
import com.compose.rmcomposechallenge.ui.theme.BlackBackground
import com.compose.rmcomposechallenge.ui.theme.RMcomposechallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMcomposechallengeTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Characters",
                                    route = Screens.CharactersScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_baseline_view_list_24)
                                ),
                                BottomNavItem(
                                    name = "Home",
                                    route = Screens.HomeScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_baseline_home_24)
                                ),

                                BottomNavItem(
                                    name = "About",
                                    route = Screens.AboutScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_baseline_info_24)
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) { padding ->
                    Column(modifier = Modifier.padding(padding)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.CharactersScreen.route) {
            HomeScreen()
        }
        composable(Screens.HomeScreen.route) {
            CharactersScreen()
        }
        composable(Screens.AboutScreen.route) {
            AboutScreen()
        }
    }
}

@Composable
fun CharactersScreen() {
    LazyColumn(modifier = Modifier
        .fillMaxHeight()
        .background(BlackBackground)) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(140.dp, 140.dp),
                    painter = painterResource(id = R.drawable.mort),
                    contentDescription = "Rick and Morty Image",
                )
                Text(
                    text = "Rick and Morty",
                    color = Color.White,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(horizontal = 22.dp)
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
                    modifier = Modifier.padding(horizontal = 15.dp),
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "Characters",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = 22.dp)
                )

                val viewModel: CharactersViewModel = hiltViewModel()

                val state = viewModel.state.value

                LazyRow {
                    state.characters?.results?.let {
                        items(it.size) { i ->
                            val character = it[i]
                            RickAndMortyCharacterHome(character)
                        }
                    }
                }

            }
        }
    }

}

@Composable
fun AboutScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                stringResource(id = R.string.created),
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                stringResource(id = R.string.gideon),
                style = MaterialTheme.typography.h6
            )
            Text(
                stringResource(id = R.string.Dan),
                style = MaterialTheme.typography.h6
            )
            Text(
                stringResource(id = R.string.Anwar),
                style = MaterialTheme.typography.h6
            )
            Text(
                stringResource(id = R.string.Abdul),
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                stringResource(id = R.string.Api),
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                stringResource(id = R.string.api),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharactersDetailScreen() {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(140.dp, 140.dp),
                    painter = painterResource(id = R.drawable.mort),
                    contentDescription = "Rick and Morty Image",
                )
//                AsyncImage(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(10.dp)
//                        .clip(RoundedCornerShape(10)),
//                  model = character.image,
//                    contentDescription = "Character Image",
//                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10)),
                    border = BorderStroke(2.dp, Color.LightGray),
                    elevation = 4.dp
                ) {
                    Column {
                        Row {
                            Text(
                                text = "Status:",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )

                            Text(
                                text = "Rick and Morty",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )
                        }
                        Row {
                            Text(
                                text = "Species:",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )

                            Text(
                                text = "Rick and Morty",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )
                        }
                        Row {
                            Text(
                                text = "Gender:",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )

                            Text(
                                text = "Rick and Morty",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )
                        }
                        Row {
                            Text(
                                text = "Origin:",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )

                            Text(
                                text = "Rick and Morty",
                                color = Color.White,
                                style = MaterialTheme.typography.h1,
                                modifier = Modifier.padding(horizontal = 22.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

