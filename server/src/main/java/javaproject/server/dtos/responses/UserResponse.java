package javaproject.server.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private String imageURL;
    private String role;
}
