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
    fun signin(@Body request: AuthRequest): Call<BaseResponse<AuthResponse>>

    @POST("user")
    fun createUser(@Body request: UserRequest): Call<BaseResponse<UserResponse>>

//    @PATCH("user")
//    fun updateUserDetail(@Body )
}