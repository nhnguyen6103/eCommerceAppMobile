package com.javaproject.mobile.data.repository;

import com.javaproject.mobile.data.model.requests.UserRequest;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.UserResponse;
import com.javaproject.mobile.data.network.UserApi;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/javaproject/mobile/data/repository/UserRepository;", "", "userApi", "Lcom/javaproject/mobile/data/network/UserApi;", "(Lcom/javaproject/mobile/data/network/UserApi;)V", "createUser", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "Lcom/javaproject/mobile/data/model/responses/UserResponse;", "request", "Lcom/javaproject/mobile/data/model/requests/UserRequest;", "(Lcom/javaproject/mobile/data/model/requests/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserDetail", "token", "", "(Ljava/lang/String;Lcom/javaproject/mobile/data/model/requests/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.javaproject.mobile.data.network.UserApi userApi = null;
    
    @javax.inject.Inject
    public UserRepository(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.network.UserApi userApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createUser(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.UserRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.UserResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateUserDetail(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.UserRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.UserResponse>> $completion) {
        return null;
    }
}