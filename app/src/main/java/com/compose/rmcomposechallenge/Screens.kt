package com.compose.rmcomposechallenge

sealed class Screens(val route:String){
    object HomeScreen: Screens("home_screen")
    object MyFilesScreen: Screens("myfiles_screen")
    object  SettingsScreen:Screens("settings_screen")

    object CharacterDetailScreen: Screens("character_detail_screen")
}
