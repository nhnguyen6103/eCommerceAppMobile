package com.javaproject.mobile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javaproject.mobile.data.model.requests.UserRequest
import com.javaproject.mobile.data.repository.UserRepository
import com.javaproject.mobile.utils.Constants.Companion.TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun update(request: UserRequest) {
        viewModelScope.launch {
            val response = userRepository.updateUserDetail(TOKEN,request)
            response.data

        }
    }
}