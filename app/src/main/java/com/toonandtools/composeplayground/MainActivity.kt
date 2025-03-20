package com.toonandtools.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toonandtools.composeplayground.data.AppsData
import com.toonandtools.composeplayground.data.appItems
import com.toonandtools.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//
//                }
            }
        }
    }

    @Preview
    @Composable
    private fun ComposePlayground() {
        ComposePlaygroundApp()
    }

    @Composable
    fun ComposePlaygroundApp() {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp), // Each column will be at least 128.dp wide
            modifier = Modifier.fillMaxSize()
        ) {
            items(appItems) { app ->
                ComposePlaygroundItem(
                    app = app,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }


    }


    @Composable
    fun ComposePlaygroundItem(
        app: AppsData,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        // Navigate to the next screen when card is clicked
                    }
            ) {
                Image(
                    painter = painterResource(app.image),
                    contentDescription = stringResource(app.title),
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(app.title),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }


        }
    }
}

