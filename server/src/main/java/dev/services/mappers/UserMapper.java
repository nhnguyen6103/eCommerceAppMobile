package dev.services.mappers;

import dev.dtos.requests.UserRequest;
import dev.dtos.responses.UserResponse;
import dev.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserMapper() {
    }

    public User toUser(UserRequest request) {
        if (request == null) {
            return null;
        } else {
            User.UserBuilder user = User.builder();
            user.username(request.getUsername());
            user.email(request.getEmail());
            user.phoneNumber(request.getPhoneNumber());
            user.password(request.getPassword());
            return user.build();
        }
    }

    public UserResponse toUserResponse(User user) {
        if (user == null) {
            return null;
        } else {
            UserResponse.UserResponseBuilder userResponse = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .imageURL(user.getImageURL());
            return userResponse.build();
        }
    }

    public UserResponse toUserResponseWithRole(User user) {
        if (user == null) {
            return null;
        } else {
            UserResponse.UserResponseBuilder userResponse = UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .phoneNumber(user.getPhoneNumber())
                    .imageURL(user.getImageURL());
            return userResponse.build();
        }
    }

}
