package com.javaproject.mobile.data.repository

import com.javaproject.mobile.data.model.requests.AuthRequest
import com.javaproject.mobile.data.model.responses.AuthResponse
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.network.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authApi: AuthApi) {
    suspend fun signin(request: AuthRequest) :BaseResponse<AuthResponse> = authApi.signin(request)
}