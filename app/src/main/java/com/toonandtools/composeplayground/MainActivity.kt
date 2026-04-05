package com.toonandtools.composeplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.toonandtools.composeplayground.data.AppsData
import com.toonandtools.composeplayground.data.appItems
import com.toonandtools.composeplayground.navigation.Screen
import com.toonandtools.composeplayground.ui.theme.ComposePlaygroundTheme
import com.toonandtools.composeplayground.viewmodel.MainViewModel
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {

                    composable(Screen.Home.route) {
                        ComposePlaygroundApp(navController = navController)
                    }

                    composable(Screen.ArtSpace.route) {
                       SpaceCreation(navController)
                    }

                    composable(Screen.Affirmations.route) {
                        App(navController)
                    }

                    composable(Screen.Counter.route) {
                        CounterApp(navController)
                    }

                    composable(Screen.ApiSimulator.route) {
                        ApiSimulatorApp(navController)
                    }
                }
                Scaffold(modifier = Modifier.fillMaxSize()) {contentPadding ->
                ComposePlaygroundApp(contentPadding,navController)
                }
            }
        }
    }
//
//    @Preview
//    @Composable
//    private fun ComposePlayground() {
//        ComposePlaygroundApp()
//    }

    @Composable
    fun ComposePlaygroundApp(contentPadding: PaddingValues = PaddingValues(0.dp),navController: NavController) {
        val poppinsFamily = FontFamily(
            Font(R.font.poppins, FontWeight.Normal)
        )
        val viewModel = MainViewModel()
        val apps by viewModel.apps.collectAsState()

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_small))
                .padding(paddingValues = contentPadding)

        ){
            Text(
                text = "Compose Playground",
                modifier = Modifier.padding(start = 28.dp, top = 28.dp),
                fontFamily = poppinsFamily,
                fontSize = 18.sp
            )



            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp), // Each column will be at least 128.dp wide
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(apps) { app ->
                    ComposePlaygroundItem(
                        app = app,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                        onClick = {
                            navController.navigate(getRoute(app))
                        }

                    )
                }
            }
        }



    }

    fun getRoute(app: AppsData): String {
        return when (app.title) {
            R.string.art_space -> Screen.ArtSpace.route
            R.string.affirmations -> Screen.Affirmations.route
            R.string.counter -> Screen.Counter.route
            R.string.api_simulator -> Screen.ApiSimulator.route
            else -> Screen.Home.route
        }
    }


    @Composable
    fun ComposePlaygroundItem(
        app: AppsData,
        modifier: Modifier = Modifier,
        onClick: () -> Unit
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable {
                        onClick()
                    }
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
        }

}

