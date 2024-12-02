package dev.dtos.requests;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String category;
    private Integer quantity;
    private String description;
    private Double price;
}
