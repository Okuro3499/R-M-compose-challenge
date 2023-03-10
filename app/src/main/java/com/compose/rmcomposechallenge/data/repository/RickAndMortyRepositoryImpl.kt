package com.compose.rmcomposechallenge.data.repository

import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.data.network.RickAndMortyService
import com.compose.rmcomposechallenge.domain.models.Characters
import com.compose.rmcomposechallenge.domain.models.Result
import com.compose.rmcomposechallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RickAndMortyRepositoryImpl(
    private val apiService: RickAndMortyService,
): RickAndMortyRepository {
    override fun getAllCharacters(): Flow<ResultWrapper<Characters>> = flow {

       // try {
        val remoteData = apiService.getCharactersList().toCharacters()
        emit(ResultWrapper.success(remoteData))
        //}catch (e: IOException){
          //  emit(ResultWrapper.failure(e))
        //}catch (e: HttpException){
          //  emit(ResultWrapper.failure( e))
//        }
    }

    override fun getCharacterDetails(id: Int): Flow<ResultWrapper<Result>> = flow{
        val remoteData = apiService.getCharacterDetails(id).toResults()
        emit(ResultWrapper.success(remoteData))
    }


}