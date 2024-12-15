package javaproject.server.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthResponse {
    private String token;
    private UserResponse user;
}
