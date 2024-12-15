package javaproject.server.dtos.requests;

import lombok.NonNull;

@NonNull
public class CartRequest {
    private String productID;
    private Integer quantity;

    public CartRequest(String productID, Integer quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public CartRequest() {
    }

    public String getProductID() {
        return productID;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
