package com.javaproject.mobile.data.network

import com.javaproject.mobile.data.model.requests.AuthRequest
import com.javaproject.mobile.data.model.requests.UserRequest
import com.javaproject.mobile.data.model.responses.AuthResponse
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApi {
    @POST("auth/signin")
    suspend fun signin(@Body request: AuthRequest): BaseResponse<AuthResponse>
}