package com.compose.rmcomposechallenge.data.network.dto

import com.compose.rmcomposechallenge.domain.models.Origin

data class OriginDTO (
    val name: String,
    val url: String
        ){
    fun toOrigin(): Origin{
        return Origin(
            name = name,
            url = url
        )
    }
}
