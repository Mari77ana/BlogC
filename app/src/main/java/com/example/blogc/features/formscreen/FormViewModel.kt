package com.example.blogc.features.formscreen

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogc.model.User
import com.example.blogc.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FormViewModel(  val userId: Int?) : ViewModel() {

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

    fun saveUser() {
        viewModelScope.launch {
            try {


                    val user = User(
                        id = null, // because we don't have any id yet
                        name = userUiState.value.name,
                        lastname = userUiState.value.lastname,
                        email = userUiState.value.email,
                        password = userUiState.value.password,
                        comment = ""
                    )
                    val savedUser = RetrofitInstance.saveUser(user)

                    println("USER SAVED $savedUser")
                    Log.e("savxing user", "success")



            } catch (e: Exception) {
                println("FAILED -> USER NOT SAVED $")
                Log.e("saving user", "failed", e)

            }


        }

    }

}



data class UiState(
    val name: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = ""
)