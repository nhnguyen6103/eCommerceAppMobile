package com.javaproject.myapplication.data.repository

import com.javaproject.myapplication.data.model.request.UserRequest
import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.UserResponse
import com.javaproject.myapplication.data.network.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi) {
    suspend fun createUser(
        request: UserRequest
    ): BaseResponse<UserResponse> = userApi.createUser(request)
    suspend fun updateUserDetail(
        token: String ,
        request: UserRequest
    ): BaseResponse<UserResponse> = userApi.updateUserDetail(token ,request)

    //Update user Image
}