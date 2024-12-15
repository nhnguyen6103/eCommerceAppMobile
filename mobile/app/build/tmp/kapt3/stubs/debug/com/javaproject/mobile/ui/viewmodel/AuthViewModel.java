package com.javaproject.mobile.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.javaproject.mobile.data.model.requests.AuthRequest;
import com.javaproject.mobile.data.model.responses.AuthResponse;
import com.javaproject.mobile.data.model.responses.BaseResponse;
import com.javaproject.mobile.data.repository.AuthRepository;
import com.javaproject.mobile.data.repository.ProductRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/javaproject/mobile/ui/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/javaproject/mobile/data/repository/AuthRepository;", "(Lcom/javaproject/mobile/data/repository/AuthRepository;)V", "signin", "", "request", "Lcom/javaproject/mobile/data/model/requests/AuthRequest;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.javaproject.mobile.data.repository.AuthRepository authRepository = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.repository.AuthRepository authRepository) {
        super();
    }
    
    public final void signin(@org.jetbrains.annotations.NotNull
    com.javaproject.mobile.data.model.requests.AuthRequest request) {
    }
}