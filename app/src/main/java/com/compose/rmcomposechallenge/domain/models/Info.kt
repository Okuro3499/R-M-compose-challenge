package com.compose.rmcomposechallenge.domain.models

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String?
)