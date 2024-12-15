package javaproject.server.entities;

import jakarta.persistence.*;
import java.util.*;

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

    public String getId() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public List<CartItem> getSetProduct() {
        return setProduct;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSetProduct(List<CartItem> setProduct) {
        this.setProduct = setProduct;
    }
}
