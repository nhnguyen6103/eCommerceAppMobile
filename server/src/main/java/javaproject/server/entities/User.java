package javaproject.server.entities;

import jakarta.persistence.*;
import lombok.Builder;


import java.util.UUID;

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

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
