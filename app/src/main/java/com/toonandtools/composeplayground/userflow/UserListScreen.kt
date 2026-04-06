package com.toonandtools.composeplayground.userflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.toonandtools.composeplayground.R

@Composable
fun UserListScreen(navController: NavController) {
    val users = listOf("Anjali", "Rahul", "Priya")

    UserListContent(
        users = users,
        onUserClick = { user ->
            navController.navigate("user_detail/$user")
        }
    )
}

@Composable
fun UserListContent(
    users: List<String>,
    onUserClick: (String) -> Unit
) {
    val poppinsFamily = FontFamily(
        Font(R.font.poppins, FontWeight.Normal)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        users.forEach { user ->
            Text(
                text = user,
                fontFamily = poppinsFamily,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        onUserClick(user)
                    }
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserListPreview() {
    UserListContent(
        users = listOf("Anjali", "Rahul", "Priya"),
        onUserClick = {}
    )
}