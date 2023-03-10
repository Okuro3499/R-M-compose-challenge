package com.compose.rmcomposechallenge.data.network.dto

import com.compose.rmcomposechallenge.domain.models.Location

data class LocationDTO (
    val name: String,
    val url: String
    ){
    fun toLocation(): Location{
        return Location(
            name = name,
            url = url
        )
    }
}
