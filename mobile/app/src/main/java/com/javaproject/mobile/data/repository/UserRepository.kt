package com.javaproject.mobile.data.repository

import com.javaproject.mobile.data.model.requests.UserRequest
import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.UserResponse
import com.javaproject.mobile.data.network.UserApi
import com.javaproject.mobile.utils.Constants.Companion.TOKEN
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