package com.toonandtools.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.toonandtools.composeplayground.viewmodel.CounterViewModel

class Counter : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                val navController = rememberNavController()
                CounterApp(navController)
            }
        }
    }
}


@Composable
fun CounterApp(navController: NavController) {
//    var count by rememberSaveable { mutableIntStateOf(0) }
    val activity = LocalActivity.current
    val viewModel: CounterViewModel = viewModel()
    val uiState by viewModel.count.collectAsState()
    val currentCount = uiState.count

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .clickable {
                    activity?.finish()
                }
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Count: ${currentCount}")

            Counter(
                count = currentCount,
                onIncrement = { viewModel.increment() },
                onDecrement = {
                    viewModel.decrement()
                },
                onReset = { viewModel.reset() },
                isDecrementEnabled = currentCount > 0
            )
        }
    }
}

@Composable
fun Counter(count: Int,
            onIncrement: () -> Unit,
            onDecrement: () -> Unit,
            onReset: () -> Unit,
            isDecrementEnabled: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onIncrement) {
            Text("+")
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(onClick = onDecrement, enabled = isDecrementEnabled) {
            Text("-")
        }
        Spacer(modifier = Modifier.width(12.dp))
        Button(onClick = onReset) {
            Text("Reset")
        }
    }

}

@Preview(backgroundColor = 0xffffffff, showBackground = true, showSystemUi = true)
@Composable
private fun CounterAppPreview() {
    ComposePlaygroundTheme {
        CounterApp(navController = rememberNavController())
    }
}