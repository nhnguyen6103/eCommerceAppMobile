package com.javaproject.myapplication.data.network

import com.javaproject.myapplication.data.model.request.AuthRequest
import com.javaproject.myapplication.data.model.response.AuthResponse
import com.javaproject.myapplication.data.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/signin")
    suspend fun signin(
        @Body request: AuthRequest
    ): BaseResponse<AuthResponse>
}