package com.javaproject.mobile.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javaproject.mobile.data.model.requests.AuthRequest
import com.javaproject.mobile.data.model.responses.AuthResponse
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.repository.AuthRepository
import com.javaproject.mobile.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    //private val _response = MutableLiveData<BaseResponse<AuthResponse>>()
    //val response: LiveData<BaseResponse<AuthResponse>> get() = _response

    fun signin(request: AuthRequest) {
        viewModelScope.launch {
                val apiResponse = authRepository.signin(request)
               // _response.postValue(apiResponse)
            apiResponse.data

        }
    }
}