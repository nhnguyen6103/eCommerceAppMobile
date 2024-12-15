package javaproject.server.dtos.requests;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;


@NonNull
public class OrderRequest {
    private String status;
    private String shippingAddress;
    private Date createdAt;
    private Date updateAt;
    private String paymentMethod;
    private String shippingMethod;
    private Double total;
    private List<OrderItemsRequest> orderItems;

    public OrderRequest(String status, String shippingAddress, Date createdAt, Date updateAt, String paymentMethod, String shippingMethod, Double total, List<OrderItemsRequest> orderItems) {
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.total = total;
        this.orderItems = orderItems;
    }

    public String getStatus() {
        return status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public Double getTotal() {
        return total;
    }

    public List<OrderItemsRequest> getOrderItems() {
        return orderItems;
    }
}
