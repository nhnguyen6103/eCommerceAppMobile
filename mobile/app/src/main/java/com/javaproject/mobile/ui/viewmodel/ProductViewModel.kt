package com.javaproject.mobile.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.javaproject.mobile.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {
    // productRepository dung de lay du lieu tu response
    // response deu co dang BaseResponse<ProductResponse>
    // Can them function de handle tu response thanh list<ProductResponse>
    // List<ProductResponse> la danh sach san pham cuoi cung

}
