package javaproject.desktop.dtos.requests;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
