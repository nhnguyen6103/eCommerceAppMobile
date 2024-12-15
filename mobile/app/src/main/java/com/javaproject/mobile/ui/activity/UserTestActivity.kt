package com.javaproject.mobile.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.javaproject.mobile.R
import com.javaproject.mobile.data.model.requests.AuthRequest
import com.javaproject.mobile.data.model.requests.UserRequest
import com.javaproject.mobile.ui.viewmodel.AuthViewModel
import com.javaproject.mobile.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserTestActivity : AppCompatActivity(){

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val request = UserRequest("TEST",null,null)
        userViewModel.update(request)
    }
}