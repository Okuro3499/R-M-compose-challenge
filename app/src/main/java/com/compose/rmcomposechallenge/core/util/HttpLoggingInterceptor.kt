package com.compose.rmcomposechallenge.core.util

import okhttp3.logging.HttpLoggingInterceptor

object HttpLogger {
    fun create(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}
