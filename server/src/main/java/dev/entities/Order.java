package dev.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @Builder.Default
    @Column(name = "id", nullable = false, updatable = false)
    private String id = UUID.randomUUID().toString();

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userID;

    @Column(name = "total_amount", nullable = false)
    private double total;

    @Column(name = "status")
    private String status;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name =  "shipping_method", nullable = false)
    private String shippingMethod;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> listOrderedItems = new ArrayList<>();


    public Order(String id, String userID, double total, String status, String shippingAddress, Date createdAt, Date updatedAt, String paymentMethod, String shippingMethod, List<OrderItem> listOrderedItems) {
        this.id = id;
        this.userID = userID;
        this.total = total;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.listOrderedItems = listOrderedItems;
    }

    public Order() {
    }
}
