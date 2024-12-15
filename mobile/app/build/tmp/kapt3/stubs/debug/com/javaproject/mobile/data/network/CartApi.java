package com.javaproject.mobile.data.network;

import com.javaproject.mobile.data.model.requests.CartRequest;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.CartResponse;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ-\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/javaproject/mobile/data/network/CartApi;", "", "addToCart", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "Lcom/javaproject/mobile/data/model/responses/CartResponse;", "token", "", "request", "Lcom/javaproject/mobile/data/model/requests/CartRequest;", "(Ljava/lang/String;Lcom/javaproject/mobile/data/model/requests/CartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "productID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCart", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProductQuantity", "app_debug"})
public abstract interface CartApi {
    
    @retrofit2.http.GET(value = "cart")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCart(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion);
    
    @retrofit2.http.POST(value = "cart")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addToCart(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.CartRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion);
    
    @retrofit2.http.PUT(value = "cart")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateProductQuantity(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.CartRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion);
    
    @retrofit2.http.DELETE(value = "cart/{productID}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteProduct(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Path(value = "productID")
    @org.jetbrains.annotations.NotNull
    java.lang.String productID, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion);
}