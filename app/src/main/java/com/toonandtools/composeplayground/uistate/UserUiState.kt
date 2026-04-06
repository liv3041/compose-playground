package com.toonandtools.composeplayground.uistate

sealed class UserUiState {

    object Loading : UserUiState()

    data class Success(val data: String) : UserUiState()

    data class Error(val message: String) : UserUiState()
}