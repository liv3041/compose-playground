package com.toonandtools.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toonandtools.composeplayground.uistate.ApiSimulatorUiState
import com.toonandtools.composeplayground.uistate.UserUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserDetailViewModel: ViewModel() {
    private val _state = MutableStateFlow<UserUiState>(UserUiState.Loading)
    var state: StateFlow<UserUiState> = _state

    fun loadData(){
        viewModelScope.launch {
            delay(2000)

            if ((0..1).random() == 0) {
                _state.value = UserUiState.Success("Data Loaded")
            } else {
                _state.value = UserUiState.Error("Something went wrong")
            }
        }
    }
}