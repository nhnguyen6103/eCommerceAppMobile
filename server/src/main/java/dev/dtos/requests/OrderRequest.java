package dev.dtos.requests;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
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
}
