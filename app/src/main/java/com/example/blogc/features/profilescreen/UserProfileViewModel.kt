package com.example.blogc.features.profilescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogc.model.User
import com.example.blogc.retrofit_api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel( val userId: Int): ViewModel() {

    private val _userUiState = MutableStateFlow<User?>(null)
    val userUiState: StateFlow<User?> = _userUiState.asStateFlow()

    // Get RetrofitInstance
    private val userApi = RetrofitInstance

    // Constructor for showing userId
    init {
        getUserById(userId)
    }

    private fun getUserById(userId: Int) {
        viewModelScope.launch {
            try {
                _userUiState.value = userApi.getUserById(userId)

                Log.e("Get userId", "Success", )
                println("GET USER ID -> SUCCESS")

            } catch (e: Exception) {
                Log.e("Get userId", "Failed", e)
                println("GET USER ID -> FAILED")
            }
        }

    }


}