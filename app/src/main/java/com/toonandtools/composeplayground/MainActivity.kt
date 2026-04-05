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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import com.toonandtools.composeplayground.data.AppsData
import com.toonandtools.composeplayground.data.appItems
import com.toonandtools.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {contentPadding ->
                ComposePlaygroundApp(contentPadding)
                }
            }
        }
    }

    @Preview
    @Composable
    private fun ComposePlayground() {
        ComposePlaygroundApp()
    }

    @Composable
    fun ComposePlaygroundApp(contentPadding: PaddingValues = PaddingValues(0.dp)) {
        val poppinsFamily = FontFamily(
            Font(R.font.poppins, FontWeight.Normal)
        )
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
                items(appItems) { app ->
                    ComposePlaygroundItem(
                        app = app,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
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
//                        val context = LocalContext.current
                        val intent = when (app.title) {
                            R.string.art_space -> Intent(this@MainActivity, ArtSpace::class.java)
                            R.string.affirmations -> Intent(
                                this@MainActivity,
                                AffirmationsActivity::class.java
                            )

                            R.string.counter -> Intent(
                                this@MainActivity,
                                Counter::class.java
                            )

                            else -> Intent(
                                this@MainActivity,
                                MainActivity::class.java
                            ) // Default fallback
                        }
                        this@MainActivity.startActivity(intent)
                    }
            ) {
                Image(
                    painter = painterResource(app.image),
                    contentDescription = stringResource(app.title),
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(app.title),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp)
                )
            }


        }
        }

}

