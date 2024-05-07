package com.example.blogc.features.formscreen

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.blogc.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel: ViewModel() {

    private val _userUiState = MutableStateFlow(UiState())
    val userUiState: StateFlow<UiState> = _userUiState.asStateFlow()

    fun updateName(name: String) {
            _userUiState.value = _userUiState.value.copy(
                name = name
            )
            println("UPDATE Name $name")

    }


    fun updateLastname(lastname: String) {
            _userUiState.value = _userUiState.value.copy(
                lastname = lastname
            )
            println("UPDATE Lastname $lastname")

    }



    fun updateEmail(email: String) {
        _userUiState.value = _userUiState.value.copy(
            email = email
        )
        println("UPDATE Email $email")

    }


    fun updatePassword(password: String) {
            _userUiState.value = _userUiState.value.copy(
                password = password
            )
            println("UPDATE Password $password")

    }

    data class UiState(
        val name: String = "",
        val lastname: String = "",
        val email: String = "",
        val password: String = ""
    )















}