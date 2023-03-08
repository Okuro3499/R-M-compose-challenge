package com.compose.rmcomposechallenge.di

import com.compose.rmcomposechallenge.core.util.Constants.BASE_URL
import com.compose.rmcomposechallenge.core.util.HttpClient
import com.compose.rmcomposechallenge.core.util.HttpLogger
import com.compose.rmcomposechallenge.data.network.RickAndMortyService
import com.compose.rmcomposechallenge.data.repository.RickAndMortyRepositoryImpl
import com.compose.rmcomposechallenge.domain.repository.RickAndMortyRepository
import com.compose.rmcomposechallenge.domain.usecases.GetAllCharacters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RickAndMortyModule {
    @Provides
    @Singleton
    fun providesAllCharactersUseCases(
        repository: RickAndMortyRepository
    ): GetAllCharacters{
        return GetAllCharacters(repository)
    }

    @Provides
    @Singleton
    fun providesRickAndMortyRepository(
        apiService: RickAndMortyService
    ): RickAndMortyRepository{
        return RickAndMortyRepositoryImpl(apiService)
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor = HttpLogger.create()

    @Provides
    fun providesHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return HttpClient.setupOkHttpClient(httpLoggingInterceptor)
    }

    @Provides
    @Singleton
    fun providesRickAndMortyApiService(okHttpClient: OkHttpClient): RickAndMortyService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RickAndMortyService::class.java)
    }


}