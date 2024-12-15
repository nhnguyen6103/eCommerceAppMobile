package com.javaproject.mobile.data.model.requests;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006+"}, d2 = {"Lcom/javaproject/mobile/data/model/requests/OrderRequest;", "", "status", "", "shippingAddress", "createdAt", "Ljava/time/LocalDateTime;", "updateAt", "paymentMethod", "shippingMethod", "total", "", "orderItems", "", "Lcom/javaproject/mobile/data/model/requests/OrderItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Ljava/lang/String;Ljava/lang/String;DLjava/util/List;)V", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getOrderItems", "()Ljava/util/List;", "getPaymentMethod", "()Ljava/lang/String;", "getShippingAddress", "getShippingMethod", "getStatus", "getTotal", "()D", "getUpdateAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class OrderRequest {
    @com.google.gson.annotations.SerializedName(value = "status")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "shippingAddress")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shippingAddress = null;
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @com.google.gson.annotations.SerializedName(value = "updateAt")
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime updateAt = null;
    @com.google.gson.annotations.SerializedName(value = "paymentMethod")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String paymentMethod = null;
    @com.google.gson.annotations.SerializedName(value = "shippingMethod")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shippingMethod = null;
    @com.google.gson.annotations.SerializedName(value = "total")
    private final double total = 0.0;
    @com.google.gson.annotations.SerializedName(value = "orderItems")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.javaproject.mobile.data.model.requests.OrderItem> orderItems = null;
    
    public OrderRequest(@org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String shippingAddress, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updateAt, @org.jetbrains.annotations.NotNull
    java.lang.String paymentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String shippingMethod, double total, @org.jetbrains.annotations.NotNull
    java.util.List<com.javaproject.mobile.data.model.requests.OrderItem> orderItems) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShippingAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getUpdateAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPaymentMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShippingMethod() {
        return null;
    }
    
    public final double getTotal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.javaproject.mobile.data.model.requests.OrderItem> getOrderItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.javaproject.mobile.data.model.requests.OrderItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.javaproject.mobile.data.model.requests.OrderRequest copy(@org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String shippingAddress, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updateAt, @org.jetbrains.annotations.NotNull
    java.lang.String paymentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String shippingMethod, double total, @org.jetbrains.annotations.NotNull
    java.util.List<com.javaproject.mobile.data.model.requests.OrderItem> orderItems) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}