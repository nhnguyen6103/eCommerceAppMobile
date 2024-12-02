package dev.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "carts")
public class Cart {

    public Cart() {

    }

    public Cart(String id, String userID) {
        this.id = id;
        this.userID = userID;
    }

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "user_id")
    private String userID;

    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CartItem> setProduct = new ArrayList<>();

}
