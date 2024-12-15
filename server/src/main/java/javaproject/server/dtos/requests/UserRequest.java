package javaproject.server.dtos.requests;

import lombok.Data;


public class UserRequest {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;

    public UserRequest(String username, String email, String phoneNumber, String password) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public UserRequest() {
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

    public String getPassword() {
        return password;
    }
}
