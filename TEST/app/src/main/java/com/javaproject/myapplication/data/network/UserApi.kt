package com.javaproject.myapplication.data.network

import com.javaproject.myapplication.data.model.request.UserRequest
import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface UserApi {
    @POST("user")
    suspend fun createUser(
        @Body request: UserRequest
    ): BaseResponse<UserResponse>

    @PATCH("user")
    suspend fun updateUserDetail(
        @Header("Authorization")token: String,
        @Body request: UserRequest
    ): BaseResponse<UserResponse>


}