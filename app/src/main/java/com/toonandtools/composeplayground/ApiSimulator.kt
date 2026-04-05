package com.toonandtools.composeplayground

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.toonandtools.composeplayground.ui.theme.ComposePlaygroundTheme
import com.toonandtools.composeplayground.uistate.ApiSimulatorUiState
import com.toonandtools.composeplayground.viewmodel.ApiSimulatorViewModel

class ApiSimulator: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                val navController = rememberNavController()
                ApiSimulatorApp(navController = navController)
            }
        }
    }
}

@Composable
fun ApiSimulatorApp(navController: NavController) {
    val viewModel: ApiSimulatorViewModel = viewModel()
    val uiState by viewModel.state.collectAsState()
    val state = uiState

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            when (state) {
                is ApiSimulatorUiState.Loading -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator()
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Loading...")
                    }
                }

                is ApiSimulatorUiState.Success -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(state.data)
                    }
                }

                is ApiSimulatorUiState.Error -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(state.message)

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            "Click to Retry",
                            modifier = Modifier.clickable {
                                viewModel.loadData()
                            }
                        )
                    }
                }
            }

        }
    }
}

@Preview(backgroundColor = 0xffffffff, showBackground = true, showSystemUi = true)
@Composable
private fun ApiSimulatorPreview() {
    ComposePlaygroundTheme {
        val navController = rememberNavController()
        ApiSimulatorApp(navController = navController)
    }
}