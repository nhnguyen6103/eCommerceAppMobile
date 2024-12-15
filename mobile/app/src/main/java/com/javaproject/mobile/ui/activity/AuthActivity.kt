package com.javaproject.mobile.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.javaproject.mobile.R
import com.javaproject.mobile.data.model.requests.AuthRequest
import com.javaproject.mobile.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AuthActivity : AppCompatActivity(){
    // AuthResponse gom token va userresponse
    // Sau khi thuc hien signin va da lay duoc reponse
    // Phai luu token vao bien token trong file constant de su dung ve sau
    // Khi luu phai luu kem them "Bearer $token"
    // VD: "Bearer eyJhbGciOiJIUzUxMi..."

    private val authViewModel:AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val request = AuthRequest("user2@us.com", "12345678")
        authViewModel.signin(request)
    }
}