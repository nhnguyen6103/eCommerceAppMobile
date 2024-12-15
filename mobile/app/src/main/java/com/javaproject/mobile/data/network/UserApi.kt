package com.javaproject.mobile.data.network

import com.javaproject.mobile.data.model.requests.UserRequest
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.UserResponse
import retrofit2.Call
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