package com.javaproject.mobile.data.repository;

import com.javaproject.mobile.data.model.requests.CartRequest;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.CartResponse;
import com.javaproject.mobile.data.network.CartApi;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ)\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/javaproject/mobile/data/repository/CartRepository;", "", "cartApi", "Lcom/javaproject/mobile/data/network/CartApi;", "(Lcom/javaproject/mobile/data/network/CartApi;)V", "addToCart", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "Lcom/javaproject/mobile/data/model/responses/CartResponse;", "token", "", "request", "Lcom/javaproject/mobile/data/model/requests/CartRequest;", "(Ljava/lang/String;Lcom/javaproject/mobile/data/model/requests/CartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "productID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCart", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProductQuantity", "app_debug"})
public final class CartRepository {
    @org.jetbrains.annotations.NotNull
    private final com.javaproject.mobile.data.network.CartApi cartApi = null;
    
    @javax.inject.Inject
    public CartRepository(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.network.CartApi cartApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addToCart(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.CartRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCart(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateProductQuantity(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.CartRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteProduct(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String productID, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.CartResponse>> $completion) {
        return null;
    }
}