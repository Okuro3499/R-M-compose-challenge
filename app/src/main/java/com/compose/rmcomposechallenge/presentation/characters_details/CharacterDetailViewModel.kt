package com.compose.rmcomposechallenge.presentation.characters_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.core.util.Constants
import com.compose.rmcomposechallenge.domain.usecases.GetCharacterDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetails: GetCharacterDetails,
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> get() = _state

    init {
        savedStateHandle.get<String>(Constants.CHARACTER_ID)?.let {
            showCharacterDetails(it.toInt())
        }
    }

    fun showCharacterDetails(id: Int) {
        viewModelScope.launch {
            getCharacterDetails(id)
                .collect { results ->
                    when(results) {
                        is ResultWrapper.success -> {
                            _state.value = state.value.copy(
                                character = results.value ?: null,
                                error = null
                            )
                        }
                        is ResultWrapper.failure -> {
                            _state.value = state.value.copy(
                                character = null,
                                error = results.exception.toString()
                            )
                        }

                        ResultWrapper.Loading -> TODO()
                    }
                }
        }
    }

}