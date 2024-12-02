package dev.dtos.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
}
