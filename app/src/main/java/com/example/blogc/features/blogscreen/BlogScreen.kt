package com.example.blogc.features.blogscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlogScreen(
    blogViewModel: BlogViewModel,
    onTitleChanged: () -> Unit,
    onDescriptionChanged: () -> Unit,
    navigateToProfileScreen: () -> Unit,
    navigateToUserListScreen: () -> Unit
) {
    val uiState by blogViewModel.blogUiState.collectAsState()
    var expanded = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4D726E),


                    ),
                title = { Text(text = "Write Blog") },
                actions = {
                    IconButton(
                        onClick = { expanded.value = true }
                    ) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                    DropdownMenu(
                        navigateToUserListScreen = { navigateToProfileScreen() },
                        navigateToProfileScreen = { navigateToUserListScreen() },
                        expanded = expanded
                    )


                }

            )

        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFF4D726E)) { }
        }


    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.padding(bottom = 60.dp))

            // TODO add TextField and Button
            // for saving blog
            TextField(
                value = uiState.title,
                onValueChange = { blogViewModel.updateTitle(it)},
                label = { Text(text = "Title")}
            )
            Spacer(modifier = Modifier.padding(bottom = 40.dp))

            TextField(
                value = uiState.description,
                onValueChange = { blogViewModel.updateDescription(it)},
                label = { Text(text = "Description")}
            )
            Spacer(modifier = Modifier.padding(bottom = 40.dp))

            Button(
                modifier = Modifier
                    .width(280.dp)
                    .padding(top = 10.dp),
                onClick =
                { /*TODO 1: Save Blog,*/

                }
            ) {
                Text(text = "Save")
            }



        }


    }


}


@Composable
fun DropdownMenu(
    navigateToUserListScreen: () -> Unit,
    navigateToProfileScreen: () -> Unit,
    expanded: MutableState<Boolean>
) {
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = {
            expanded.value = false
        }
    ) {
        DropdownMenuItem(
            text = { Text(text = "Profile") },
            onClick = { navigateToProfileScreen() }
        )
        DropdownMenuItem(
            text = { Text(text = "Bloggers") },
            onClick = { navigateToUserListScreen() }
        )

    }

}


@Preview
@Composable
fun BlogFormComponentPreview() {
    BlogScreen(
        blogViewModel = BlogViewModel(),
        onTitleChanged = {},
        onDescriptionChanged = {},
        navigateToProfileScreen = {},
        navigateToUserListScreen = {}
    )

}