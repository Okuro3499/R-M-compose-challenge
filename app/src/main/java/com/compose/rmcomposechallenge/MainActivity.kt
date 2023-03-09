package com.compose.rmcomposechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.rmcomposechallenge.presentation.characters.CharactersViewModel
import com.compose.rmcomposechallenge.presentation.characters.HomeScreen
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
                    bottomBar ={
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = Screens.HomeScreen.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Files",
                                    route =Screens.MyFilesScreen.route,
                                    icon = Icons.Default.List,
                                    badgeCount = 56
                                ),
                                BottomNavItem(
                                    name = "About",
                                    route = Screens.AboutScreen.route,
                                    icon = Icons.Default.Settings
                                )
                            ) ,
                            navController = navController,
                            onItemClick ={
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
fun Navigation(navController:NavHostController){
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
        composable(Screens.HomeScreen.route){
            HomeScreen()

        }
        composable(Screens.MyFilesScreen.route){
            MyFilesScreen()

        }
        composable(Screens.AboutScreen.route){
            AboutScreen()

        }
    }


}




@Composable
fun MyFilesScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Downloaded files")

        }

    }

@Composable
fun AboutScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
            Text(stringResource(id = R.string.created),
                style = MaterialTheme.typography.subtitle2
            )
            Text(stringResource(id = R.string.gideon),
                style = MaterialTheme.typography.h6


            )
            Text(stringResource(id = R.string.Dan),
                style = MaterialTheme.typography.h6
            )
            Text(stringResource(id = R.string.Anwar),
                style = MaterialTheme.typography.h6
            )
            Text(stringResource(id = R.string.Abdul),
                style = MaterialTheme.typography.h6
            )
            
            Spacer(modifier = Modifier.height(15.dp))
            Text(stringResource(id = R.string.Api),
                style = MaterialTheme.typography.subtitle2
            )
            Text(stringResource(id = R.string.api),
                style = MaterialTheme.typography.h6
            )



        }
    }
}

