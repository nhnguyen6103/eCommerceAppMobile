package com.javaproject.mobile.data.model.responses;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003Ji\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012\u00a8\u0006."}, d2 = {"Lcom/javaproject/mobile/data/model/responses/OrderResponse;", "", "id", "", "total", "", "status", "shippingAddress", "createdAt", "Ljava/time/LocalDateTime;", "updatedAt", "paymentMethod", "shippingMethod", "orderedItems", "", "Lcom/javaproject/mobile/data/model/responses/OrderedItemResponse;", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getId", "()Ljava/lang/String;", "getOrderedItems", "()Ljava/util/List;", "getPaymentMethod", "getShippingAddress", "getShippingMethod", "getStatus", "getTotal", "()D", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class OrderResponse {
    @com.google.gson.annotations.SerializedName(value = "id")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @com.google.gson.annotations.SerializedName(value = "total")
    private final double total = 0.0;
    @com.google.gson.annotations.SerializedName(value = "status")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "shipping_address")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shippingAddress = null;
    @com.google.gson.annotations.SerializedName(value = "createdAt")
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @com.google.gson.annotations.SerializedName(value = "updatedAt")
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime updatedAt = null;
    @com.google.gson.annotations.SerializedName(value = "paymentMethod")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String paymentMethod = null;
    @com.google.gson.annotations.SerializedName(value = "shippingMethod")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shippingMethod = null;
    @com.google.gson.annotations.SerializedName(value = "orderedItems")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.javaproject.mobile.data.model.responses.OrderedItemResponse> orderedItems = null;
    
    public OrderResponse(@org.jetbrains.annotations.NotNull
    java.lang.String id, double total, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String shippingAddress, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updatedAt, @org.jetbrains.annotations.NotNull
    java.lang.String paymentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String shippingMethod, @org.jetbrains.annotations.NotNull
    java.util.List<com.javaproject.mobile.data.model.responses.OrderedItemResponse> orderedItems) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    public final double getTotal() {
        return 0.0;
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
    public final java.time.LocalDateTime getUpdatedAt() {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.javaproject.mobile.data.model.responses.OrderedItemResponse> getOrderedItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.javaproject.mobile.data.model.responses.OrderedItemResponse> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.javaproject.mobile.data.model.responses.OrderResponse copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, double total, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String shippingAddress, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull
    java.time.LocalDateTime updatedAt, @org.jetbrains.annotations.NotNull
    java.lang.String paymentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String shippingMethod, @org.jetbrains.annotations.NotNull
    java.util.List<com.javaproject.mobile.data.model.responses.OrderedItemResponse> orderedItems) {
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