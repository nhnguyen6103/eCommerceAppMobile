package javaproject.server.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "cart_id", updatable = false, nullable = false)
    @ToString.Exclude
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @ToString.Exclude
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity = 1;

    public CartItem() {

    }
    public CartItem(String id, Cart cart, Product product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

