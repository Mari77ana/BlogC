package com.example.blogc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blogc.features.formscreen.FormScreen
import com.example.blogc.features.formscreen.FormViewModel
import com.example.blogc.features.userlistscreen.UserListScreen
import com.example.blogc.features.userlistscreen.UserListViewModel
import com.example.blogc.navigation.Navigation
import com.example.blogc.ui.theme.BlogCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*
                   FormScreen(
                       formViewModel = FormViewModel(),
                       navigateToProfile = {}
                   )

                     */
                     
                    Navigation()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlogCTheme {
       FormScreen(
           formViewModel = FormViewModel(),
           navigateToProfile = { _,_,_, -> }
       )
    }
}