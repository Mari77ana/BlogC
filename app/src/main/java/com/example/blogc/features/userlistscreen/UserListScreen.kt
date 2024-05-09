package com.example.blogc.features.userlistscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blogc.model.User



@Composable
fun UserListScreen() {

}



@Composable
fun UserCard(
    modifier: Modifier,
    user: User
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = //MaterialTheme.colorScheme.surface,
        Color.LightGray
        ),
        border = BorderStroke(6.dp, Color.Gray),
        modifier = Modifier
            .size(width = 240.dp, height = 118.dp)

    ) {
        Row(
            modifier // a square
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp) // padding outside the square
                .border(width = 1.dp, color = Color.Gray)
                .padding(12.dp) // padding outside the image
        ) {
            Column(
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Icon",
                    modifier.size(30.dp),
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = user.name,
                    fontSize = 10.sp
                )
                Text(
                    text = user.lastname,
                    fontSize = 10.sp
                )
                Text(
                    text = user.email,
                    fontSize = 10.sp
                )

            }

        }


    }



}



@Preview
@Composable
fun CardPreview(){
    UserCard(
        modifier = Modifier,
        user = User(
            0,"Valentina",
            "Ericson",
            "Emma@gmail.com",
           "",
            "Blogger"
            )

     )
}