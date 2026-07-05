package com.toonandtools.composeplayground.userflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.toonandtools.composeplayground.uistate.UserUiState
import com.toonandtools.composeplayground.viewmodel.ApiSimulatorViewModel
import com.toonandtools.composeplayground.viewmodel.UserDetailViewModel


@Composable
    fun UserDetailScreen(name: String?, navController: NavController) {

    val viewModel: UserDetailViewModel = viewModel()
    val uiState by viewModel.state.collectAsState()
    val state = uiState

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            // Back button
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.padding(16.dp)
                    .align(Alignment.TopStart)
                    .clickable{
                        navController.popBackStack()
                    }
            )

            // Content
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (state) {
                    is UserUiState.Loading -> {
                        Text("Loading...")
                    }

                    is UserUiState.Success -> {
                        Text("Hello ${state.data}")
                    }

                    is UserUiState.Error -> {
                        Text(state.message)
                    }
                }
            }
        }
    }
