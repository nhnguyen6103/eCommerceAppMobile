package javaproject.server.entities;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id",updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "category_id")
    private String categoryID;

    @Column(name = "name")
    private String name;

    @Column(name = "image_URL")
    private String imageURL;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;


    public Product(String id, String categoryID, String name, String imageURL, String description, Integer quantity, Double price) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
