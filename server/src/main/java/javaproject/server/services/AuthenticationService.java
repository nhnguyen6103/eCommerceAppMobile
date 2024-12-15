package javaproject.server.services;


import javaproject.server.dtos.responses.AuthResponse;
import javaproject.server.entities.User;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.UserMapper;
import javaproject.server.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public AuthenticationService(UserRepository userRepository, JwtService jwtService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
    }

    public AuthResponse signIn(String email, String password)
    {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()->new AppException(ErrorCode.USER_NOT_EXISTED));

        boolean authenticated = passwordEncoder().matches(password,user.getPassword());

        if(!authenticated)
            throw new AppException(ErrorCode.WRONG_PASSWORD);

        String token = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .user(userMapper.toUserResponse(user))
                .build();

    }


    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }

    public String getIdFromAuthentication()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null)
        {
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }
        return  auth.getName();
    }
}