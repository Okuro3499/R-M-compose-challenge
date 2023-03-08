package com.compose.rmcomposechallenge.data.network.dto

import com.compose.rmcomposechallenge.domain.models.Result

data class ResultDTO (
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDTO,
    val name: String,
    val origin: OriginDTO,
    val species: String,
    val status: String,
    val type: String,
    val url: String
    ){
    fun toResults(): Result{
        return Result(
            created = created,
            episode = episode,
            gender = gender,
            id = id,
            image = image,
            location = location.toLocation(),
            name = name,
            origin = origin.toOrigin(),
            species = species,
            status = status,
            type = type,
            url = url
        )
    }
}
