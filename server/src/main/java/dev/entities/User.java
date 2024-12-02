package dev.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(name = "username")
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "imageURL")
    private String imageURL;

    public User(String id, String username, String email, String phoneNumber, String role, String password, String imageURL) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
        this.imageURL = imageURL;
    }

    public User() {
    }
}
