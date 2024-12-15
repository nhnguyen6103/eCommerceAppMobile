package javaproject.server.dtos.requests;

import lombok.NonNull;


@NonNull
public class OrderItemsRequest {
    private String productID;
    private Integer quantity;
    private Double price;

    public OrderItemsRequest(String productID, Integer quantity, Double price) {
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemsRequest() {
    }

    public String getProductID() {
        return productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

}
