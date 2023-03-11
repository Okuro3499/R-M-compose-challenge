package com.compose.rmcomposechallenge

sealed class Screens(val route: String) {
    object HomeScreen : Screens("home_screen")
    object CharactersScreen : Screens("characters_screen")
    object AboutScreen : Screens("about_screen")
    object CharacterDetailScreen : Screens("character_detail_screen")
}
