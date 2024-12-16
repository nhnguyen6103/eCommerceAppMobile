package com.javaproject.myapplication.data.repository

import com.javaproject.myapplication.data.model.request.AuthRequest
import com.javaproject.myapplication.data.model.response.AuthResponse
import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.network.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authApi: AuthApi) {
    suspend fun signin(
        request: AuthRequest
    ) : BaseResponse<AuthResponse> = authApi.signin(request)
}