package com.example.blogc.features.formscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blogc.R
import com.example.blogc.model.User


@Composable
fun FormScreen(formViewModel: FormViewModel, navigateToProfile: (String, String, String) -> Unit) {

   val uiState by formViewModel.userUiState.collectAsState()
    FormComponent(
        modifier = Modifier,
        uiFormState = uiState,
        onChangedName = {formViewModel.updateName(it)},
        onChangedLastname = {formViewModel.updateLastname(it)},
        onChangedEmail = {formViewModel.updateEmail(it)},
        onChangedPassword = {formViewModel.updatePassword(it)},
        formViewModel = formViewModel,
        navigateToProfile = navigateToProfile, // could be ?,
        )
}


@Composable
fun FormComponent(
    modifier: Modifier,
    formViewModel: FormViewModel,
    uiFormState: UiState,
    onChangedName: (String) -> Unit,
    onChangedLastname: (String) -> Unit,
    onChangedEmail: (String) -> Unit,
    onChangedPassword: (String) -> Unit,
    navigateToProfile: (String, String, String) -> Unit,

    ) {

    Box()
    {
        Image(
            painter = painterResource(id = R.drawable.thoughts),
            contentDescription = "",
            contentScale = ContentScale.FillHeight, modifier = Modifier.fillMaxSize(),
            alpha = 0.5F
        )
    }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiFormState.name,
            onValueChange = { onChangedName(it) },
            label = { Text(text = "Name", style = TextStyle(Color.Blue)) },
        )


        OutlinedTextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiFormState.lastname,
            onValueChange = { onChangedLastname(it) },
            label = { Text(text = "Lastname", style = TextStyle(Color.Blue)) },
        )


        OutlinedTextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiFormState.email,
            onValueChange = {onChangedEmail(it)},
            label = { Text(text = "Email", style = TextStyle(Color.Blue)) },
        )


        OutlinedTextField(
            modifier = Modifier.padding(vertical = 4.dp),
            value = uiFormState.password,
            onValueChange = { onChangedPassword(it) },
            label = {
                Text(text = "Password", style = TextStyle(Color.Blue))
            }, visualTransformation = PasswordVisualTransformation()
        )


        Button(
            modifier = modifier
                .width(280.dp)
                .padding(top = 10.dp),

            onClick =
            { /*TODO 1: Save User,  2: Navigate to Profile*/
                formViewModel.saveUser()
                navigateToProfile(uiFormState.name, uiFormState.lastname, uiFormState.email)
                println("Button Register Tapped to navigate to ProfileScreen")
                println("Send Data To Profile ${uiFormState.name},${uiFormState.lastname}, ${uiFormState.email} ")
            }
        ) {
            Text(text = "Register")
        }


    }

}


@Preview(showBackground = true)
@Composable
fun FormScreenPreview() {
    FormScreen(
        formViewModel = FormViewModel(),
        navigateToProfile = { _, _, _  ->}
    )

}