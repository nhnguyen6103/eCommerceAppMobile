package com.javaproject.mobile.data.network;

import com.javaproject.mobile.data.model.requests.UserRequest;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/javaproject/mobile/data/network/UserApi;", "", "createUser", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "Lcom/javaproject/mobile/data/model/responses/UserResponse;", "request", "Lcom/javaproject/mobile/data/model/requests/UserRequest;", "(Lcom/javaproject/mobile/data/model/requests/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserDetail", "token", "", "(Ljava/lang/String;Lcom/javaproject/mobile/data/model/requests/UserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserApi {
    
    @retrofit2.http.POST(value = "user")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createUser(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.UserRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.UserResponse>> $completion);
    
    @retrofit2.http.PATCH(value = "user")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserDetail(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.UserRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.UserResponse>> $completion);
}