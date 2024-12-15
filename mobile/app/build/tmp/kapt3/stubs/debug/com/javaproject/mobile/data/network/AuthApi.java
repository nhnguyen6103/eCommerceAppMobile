package com.javaproject.mobile.data.network;

import com.javaproject.mobile.data.model.requests.AuthRequest;
import com.javaproject.mobile.data.model.requests.UserRequest;
import com.javaproject.mobile.data.model.responses.AuthResponse;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.model.responses.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/javaproject/mobile/data/network/AuthApi;", "", "signin", "Lcom/javaproject/mobile/data/model/responses/BaseResponse;", "Lcom/javaproject/mobile/data/model/responses/AuthResponse;", "request", "Lcom/javaproject/mobile/data/model/requests/AuthRequest;", "(Lcom/javaproject/mobile/data/model/requests/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthApi {
    
    @retrofit2.http.POST(value = "auth/signin")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signin(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.AuthRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.javaproject.mobile.data.model.responses.BaseResponse<com.javaproject.mobile.data.model.responses.AuthResponse>> $completion);
}