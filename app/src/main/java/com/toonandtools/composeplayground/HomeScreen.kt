package com.toonandtools.composeplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.toonandtools.composeplayground.data.AppsData
import com.toonandtools.composeplayground.navigation.Screen
import com.toonandtools.composeplayground.viewmodel.MainViewModel


@Composable fun ComposePlaygroundApp(
navController: NavController,
) {
    val poppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Normal)
    )

    val viewModel: MainViewModel = viewModel()
    val apps by viewModel.apps.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Compose Playground",
            modifier = Modifier.padding(28.dp),
            fontFamily = poppinsFamily,
            fontSize = 18.sp
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(apps) { app ->
                ComposePlaygroundItem(
                    app = app,
                    onClick = {
                        val route = getRoute(app)
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}
private fun getRoute(app: AppsData): String {
    return when (app.title) {
        R.string.art_space -> Screen.ArtSpace.route
        R.string.affirmations -> Screen.Affirmations.route
        R.string.counter -> Screen.Counter.route
        R.string.api_simulator -> Screen.ApiSimulator.route
        R.string.user_flow -> Screen.UserList.route
        else -> Screen.Home.route
    }
}

@Composable
fun ComposePlaygroundItem(
    app: AppsData,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick() } // This triggers the navigation
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(app.image),
                contentDescription = stringResource(app.title),
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(app.title),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}
