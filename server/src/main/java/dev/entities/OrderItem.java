package dev.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "order_items")
public class OrderItem {
    @Id
    @Column(name = "id", nullable = false,updatable = false)
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    public OrderItem(String id, Order order, Product product, int quantity, double price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }
}
