package com.toonandtools.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import com.toonandtools.composeplayground.data.AppsData
import com.toonandtools.composeplayground.data.appItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _apps = MutableStateFlow(appItems)
    val apps: StateFlow<List<AppsData>> = _apps
}