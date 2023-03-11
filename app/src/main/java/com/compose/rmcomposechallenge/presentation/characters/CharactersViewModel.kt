package com.compose.rmcomposechallenge.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.rmcomposechallenge.core.ResultWrapper
import com.compose.rmcomposechallenge.domain.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters
) : ViewModel() {

    private val _state = mutableStateOf(CharacterState())
    val state: State<CharacterState> get() = _state

    init {
        showAllCharacters()
    }

    private fun showAllCharacters() {
        getAllCharacters().onEach { result ->
            when (result) {
                is ResultWrapper.success -> {
                    _state.value = state.value.copy(
                        characters = result.value,
                        error = null
                    )
                }
                is ResultWrapper.failure -> {
                    _state.value = state.value.copy(
                        characters = null,
                        error = result.exception.toString()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}