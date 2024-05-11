package com.example.blogc.features.profilescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var expanded = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4D726E)

                ), title = { Text(text = "Profile") },

                actions = {
                    IconButton(
                        onClick = { expanded.value = true }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = {
                            expanded.value = false
                        }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Users") },
                            onClick = { /*TODO Navigate to UserListScreen*/ }
                        )

                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFF4D726E)) { }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Profile Screen")
            Text(text = "Profile Screen")

        }


    }

}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}