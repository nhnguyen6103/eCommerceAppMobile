package dev.dtos.requests;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class OrderItemsRequest {
    private String productID;
    private Integer quantity;
    private Double price;

}
