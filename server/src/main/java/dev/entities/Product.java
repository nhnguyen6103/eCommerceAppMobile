package dev.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
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

}
