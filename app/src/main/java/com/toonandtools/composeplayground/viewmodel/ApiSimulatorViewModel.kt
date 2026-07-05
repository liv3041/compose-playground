package com.toonandtools.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toonandtools.composeplayground.uistate.ApiSimulatorUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiSimulatorViewModel: ViewModel() {
    private val _state = MutableStateFlow< ApiSimulatorUiState>(ApiSimulatorUiState.Loading)
    val state: StateFlow<ApiSimulatorUiState> = _state



    fun loadData() {
        viewModelScope.launch {
            delay(2000)

            if ((0..1).random() == 0) {
                _state.value = ApiSimulatorUiState.Success("Data Loaded")
            } else {
                _state.value = ApiSimulatorUiState.Error("Something went wrong")
            }
        }
    }
}