package javaproject.server.controllers;

import javaproject.server.dtos.requests.UserRequest;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.dtos.responses.UserResponse;
import javaproject.server.services.AuthenticationService;
import javaproject.server.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationService authService;

    public UserController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<UserResponse>> getAllUser ()
    {
        return ApiResponse.<List<UserResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Success")
                .data(userService.getAllUsers())
                .build();
    }

    @PostMapping()
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request)
    {
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("CREATE SUCCESS")
                .data(userService.createUser(request))
                .build();
    }

    @PatchMapping()
    public ApiResponse<UserResponse> updateUser( @RequestBody Map<String,Object> updateFields)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE SUCCESSFULLY")
                .data(userService.updateUserDetails(userID,updateFields))
                .build();
    }

    @PutMapping()
    public ApiResponse<UserResponse> updateUserImage( @RequestParam("image") MultipartFile file)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<UserResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE SUCCESSFULLY")
                .data(userService.updateUserImage(userID, file))
                .build();
    }

}