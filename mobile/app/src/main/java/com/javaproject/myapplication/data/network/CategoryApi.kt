package com.javaproject.myapplication.data.network

import com.javaproject.myapplication.data.model.response.BaseResponse
import com.javaproject.myapplication.data.model.response.CategoryResponse
import retrofit2.http.GET

interface CategoryApi {
    @GET
    suspend fun getAllCategory(
    ) : BaseResponse<List<CategoryResponse>>
}