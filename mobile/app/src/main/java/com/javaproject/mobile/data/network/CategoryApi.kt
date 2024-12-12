package com.javaproject.mobile.data.network

import com.javaproject.mobile.data.model.responses.BaseResponse
import com.javaproject.mobile.data.model.responses.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {
    @GET
    suspend fun getAllCategory() : BaseResponse<List<CategoryResponse>>
}