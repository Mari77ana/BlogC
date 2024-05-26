package com.example.blogc.features.blogscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class BlogViewModel: ViewModel() {

    private val _uistate = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uistate.asStateFlow()

    fun updateTitle(title: String) {
        _uistate.value = _uistate.value.copy(
            title = title
        )

    }

    fun updateDescription(description: String) {
        _uistate.value = _uistate.value.copy(
            description = description
        )

    }


    // TODO Preparing fun saveBlog to a  Post Request
    fun saveBlog() {
        viewModelScope.launch {

        }
    }


}



data class UiState(
    val title: String = "",
    val description: String = ""
)