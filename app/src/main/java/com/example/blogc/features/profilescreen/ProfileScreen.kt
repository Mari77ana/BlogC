package com.example.blogc.features.profilescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blogc.R
import com.example.blogc.model.User
import com.example.blogc.navigation.Screen



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    name: String?,
    lastname: String?,
    email: String?,
     // test for receiving userId
    navigateToBlogScreen: () -> Unit,
    navigateToUserListScreen: () -> Unit,

)
{

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
                      navigateToUserListScreen = navigateToUserListScreen,
                      navigateToBlogScreen = navigateToBlogScreen,
                      expanded = expanded

                  )

                    /*
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = {
                            expanded.value = false
                        }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Bloggers") },
                            onClick = {
                            /*TODO Navigate to UserListScreen*/
                                navigateToUserListScreen()
                            }
                        )

                        DropdownMenuItem(
                            text = { Text(text = "Create Blog") },
                            onClick = {
                            /*TODO Navigate to BlogScreen*/
                                navigateToBlogScreen()
                            }
                        )



                    }

                     */
                    // slutar här
                }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xFF4D726E)) { }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Icon Person",
                tint = Color.Gray.copy(alpha = 0.5f),
                modifier = Modifier.size(130.dp)
            )
            Text(text = "Name: $name")
            Text(text = "Lastname: $lastname")
            Text(text = "email: $email")

        }


    }

}










@Composable
fun DropdownMenu(
    navigateToBlogScreen: () -> Unit,
    navigateToUserListScreen: () -> Unit,
    expanded: MutableState<Boolean>

    ) {
   // var expanded = remember { mutableStateOf(false) }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = {
            expanded.value = false
        }
    ) {
        DropdownMenuItem(
            text = { Text(text = "Bloggers") },
            onClick = {
                /*TODO Navigate to UserListScreen*/
                navigateToUserListScreen()
            }
        )

        DropdownMenuItem(
            text = { Text(text = "Create Blog") },
            onClick = {
                /*TODO Navigate to BlogScreen*/
                navigateToBlogScreen()
            }
        )

    }
}












@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        name = "Natalie",
        lastname = "Anderzen",
        email = "Anderzen@gmail.com",
        navigateToBlogScreen = { },
        navigateToUserListScreen = {}
    )



}