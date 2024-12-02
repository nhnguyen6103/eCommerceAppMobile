package dev.dtos.requests;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class CartRequest {
    private String productID;
    private Integer quantity;
}
