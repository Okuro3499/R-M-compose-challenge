package com.compose.rmcomposechallenge.core

import retrofit2.Response


sealed class ResultWrapper<out T> {
    data class success<out T>(val value: T): ResultWrapper<T>()
    data class failure<out T>(val exception: T) : ResultWrapper<T>()
    object Loading: ResultWrapper<Nothing>()
}