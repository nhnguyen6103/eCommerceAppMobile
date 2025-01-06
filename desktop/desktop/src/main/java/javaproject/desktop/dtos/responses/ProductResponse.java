package javaproject.desktop.dtos.responses;

public class ProductResponse {
    private String  id;
    private String name;
    private String  category;
    private String  imageURL;
    private String  description;
    private Integer quantity;
    private Double  price;

    public ProductResponse(String id, String name, String category, String imageURL, String description, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageURL = imageURL;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
