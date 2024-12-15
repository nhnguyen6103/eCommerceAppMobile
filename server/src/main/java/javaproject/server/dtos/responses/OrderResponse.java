package javaproject.server.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderResponse {
    private String id;
    private Double total;
    private String status;
    private String shipping_address;
    private Date createdAt;
    private Date updatedAt;
    private String paymentMethod;
    private String shippingMethod;
    private List<OrderItemsResponse> orderedItems;

    public OrderResponse(String id, Double total, String status, String shipping_address, Date createdAt, Date updatedAt, String paymentMethod, String shippingMethod, List<OrderItemsResponse> orderedItems) {
        this.id = id;
        this.total = total;
        this.status = status;
        this.shipping_address = shipping_address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.orderedItems = orderedItems;
    }

    public OrderResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public List<OrderItemsResponse> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderItemsResponse> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
