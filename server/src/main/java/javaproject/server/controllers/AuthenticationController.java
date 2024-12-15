package javaproject.server.controllers;

import javaproject.server.dtos.requests.UserRequest;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.dtos.responses.AuthResponse;
import javaproject.server.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    //Constructor
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signin")
    public ApiResponse<AuthResponse> authenticate(@RequestBody UserRequest request)
    {
        return ApiResponse.<AuthResponse>builder()
                .status(HttpStatus.OK.value())
                .message("SIGN IN SUCCESSFULLY")
                .data(authenticationService.signIn(request.getEmail(), request.getPassword()))
                .build();

    }

}
