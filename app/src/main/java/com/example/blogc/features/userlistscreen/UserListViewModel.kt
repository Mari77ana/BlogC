package com.example.blogc.features.userlistscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.blogc.model.User
import com.example.blogc.retrofit_api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel: ViewModel() {

    private val _uistate = MutableStateFlow<List<User>>(emptyList())
    val allUsersState: StateFlow<List<User>> = _uistate.asStateFlow()

    init {
        getAllUsers()
    }


    private fun getAllUsers() {
        viewModelScope.launch {
            try {
                val fetchAllUsers = RetrofitInstance.getAllUsers()
                _uistate.value = fetchAllUsers

                Log.e("Get All Users", "Success", )
                println("GET All Users -> SUCCEEDED")

            } catch (e: Exception) {
                Log.e("Get All Users", "Failed", e)
                println("GET All Users -> FAILED")
            }

        }
    }

}