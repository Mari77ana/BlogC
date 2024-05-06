package com.example.blogc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun FormScreen(modifier: Modifier = Modifier) {

        Box(
            modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Image(painter = painterResource(id = R.drawable.thoughts),
                contentDescription = "",
                contentScale = ContentScale.FillHeight, modifier = Modifier.fillMaxSize()
            )
        }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



    }

    }












@Preview(showBackground = true)
@Composable
fun FormScreenPreview(){
    FormScreen()
}