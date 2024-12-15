package javaproject.server.dtos.requests;


public class ProductRequest {
    private String name;
    private String category;
    private Integer quantity;
    private String description;
    private Double price;

    public ProductRequest(String name, String category, Integer quantity, String description, Double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
