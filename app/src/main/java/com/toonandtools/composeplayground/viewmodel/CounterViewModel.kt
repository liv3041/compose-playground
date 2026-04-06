package com.toonandtools.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import com.toonandtools.composeplayground.uistate.CounterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel: ViewModel() {
    private var _count = MutableStateFlow(CounterUiState())
    var count: StateFlow<CounterUiState> = _count

    fun increment(){
        _count.update{currentState->
            currentState.copy(count = currentState.count + 1)
        }

    }

    fun decrement(){
        _count.update{currentState->
            currentState.copy(count = currentState.count - 1)
        }
    }

    fun reset(){
        _count.update{currentState->
            currentState.copy(count = 0)
        }
    }
}