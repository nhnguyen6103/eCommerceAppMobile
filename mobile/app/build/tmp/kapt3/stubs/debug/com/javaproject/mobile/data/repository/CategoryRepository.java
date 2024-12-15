package com.javaproject.mobile.data.repository;

import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.CategoryResponse;
import com.javaproject.mobile.data.model.responses.ProductResponse;
import com.javaproject.mobile.data.network.CategoryApi;
import com.javaproject.mobile.data.network.ProductApi;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/javaproject/mobile/data/repository/CategoryRepository;", "", "categoryApi", "Lcom/javaproject/mobile/data/network/CategoryApi;", "(Lcom/javaproject/mobile/data/network/CategoryApi;)V", "getAllCategories", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "", "Lcom/javaproject/mobile/data/model/responses/CategoryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CategoryRepository {
    @org.jetbrains.annotations.NotNull
    private final com.javaproject.mobile.data.network.CategoryApi categoryApi = null;
    
    @javax.inject.Inject
    public CategoryRepository(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.network.CategoryApi categoryApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<java.util.List<com.javaproject.mobile.data.model.responses.CategoryResponse>>> $completion) {
        return null;
    }
}