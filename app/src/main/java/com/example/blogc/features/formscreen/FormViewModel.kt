package com.example.blogc.features.formscreen

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.blogc.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FormViewModel: ViewModel() {

    private val _userUiState = MutableStateFlow<User?>(null)
    val userUiState = _userUiState.asStateFlow()

    fun updateName(name: String) {
        if (name.isNotEmpty()) {
            _userUiState.value = _userUiState.value?.copy(
                name = name
            )?: User(
                id = null,
                name = name,
                lastname = null,
                email = null,
                password = null,
                comment = null
            )
            println("UPDATE Name $name")

        }


    }


    fun updateLastname(lastname: String) {
        if (lastname.isNotEmpty()) {
            _userUiState.value = _userUiState.value?.copy(
                lastname = lastname

            ) ?: User(
                id = null,
                name = null,
                lastname = lastname,
                email = null,
                password = null,
                comment = null
            )
            println("UPDATE Lastname $lastname")

        }

        fun updateEmail(email: String) {
            if (email.isNotEmpty()) {
                _userUiState.value = _userUiState.value?.copy(
                    email = email
                )?: User(
                    id = null,
                    name = null,
                    lastname = null,
                    email = email,
                    password = null,
                    comment = null
                )
                println("UPDATE Email $email")
            }
        }

        fun updatePasssword(password: String) {
            if (password.isNotEmpty()) {
                _userUiState.value = _userUiState.value?.copy(
                   password = password
                )?: User(
                    id = null,
                    name = null,
                    lastname = null,
                    email = null,
                    password = password,
                    comment = null
                )
                println("UPDATE Password $password")
            }

        }

        fun updateComment(comment: String) {
            if (comment.isNotEmpty()) {
                _userUiState.value = _userUiState.value?.copy(
                    password = comment
                )?: User(
                    id = null,
                    name = null,
                    lastname = null,
                    email = null,
                    password = null,
                    comment = comment
                )
                println("UPDATE Comment $comment")
            }

        }



    }



}