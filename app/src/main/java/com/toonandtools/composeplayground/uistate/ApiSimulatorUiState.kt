package com.toonandtools.composeplayground.uistate

sealed class ApiSimulatorUiState {

    object Loading : ApiSimulatorUiState()

    data class Success(val data: String) : ApiSimulatorUiState()

    data class Error(val message: String) : ApiSimulatorUiState()
}