package com.compose.rmcomposechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.rmcomposechallenge.ui.theme.RMcomposechallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMcomposechallengeTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar ={ BottomNavigationBar(
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
                                name = "Settings",
                                route = Screens.SettingsScreen.route,
                                icon = Icons.Default.Settings
                            )
                        ) ,
                        navController = navController,
                        onItemClick ={
                            navController.navigate(it.route)
                        }
                    )
                        
                    }
                ) {
                    Navigation(navController = navController)
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
        composable(Screens.SettingsScreen.route){
            SettingsScreen()

        }
    }


}


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home Screen")

    }
}

@Composable
fun MyFilesScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {

        Text(text = "Downloaded files" )


    }
}
@Composable
fun SettingsScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings Screen")

    }
}

