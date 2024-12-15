package javaproject.server.services;


import javaproject.server.dtos.requests.UserRequest;
import javaproject.server.dtos.responses.UserResponse;
import javaproject.server.entities.Cart;
import javaproject.server.entities.User;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.UserMapper;
import javaproject.server.repositories.CartRepository;
import javaproject.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, CartRepository cartRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.userMapper = userMapper;
    }

    @Value("${image.USER_DIR}")
    private String uploadDir;


    //Get ALL user
    public List<UserResponse> getAllUsers()
    {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseWithRole)// Can get User Role
                .toList();
    }

    //Create User
    public UserResponse createUser(UserRequest request)
    {
        //Check existence
        if(userRepository.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        //Base path of base image
        Path path  = Paths.get(uploadDir + File.separator + "base" + File.separator + "base.jpeg");


        User newUser = userMapper.toUser(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        newUser.setRole("USER");

        newUser.setImageURL(path.toString());
        userRepository.save(newUser);

        Cart cart = new Cart();
        cart.setUserID(newUser.getId());
        cartRepository.save(cart);

        return userMapper
                .toUserResponse(newUser);
    }

    //Update User Detail
    public UserResponse updateUserDetails(String userID, Map<String,Object> updateFields)
    {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // Iterate over the entries in updateFields to update the corresponding fields
        updateFields.forEach((key,value)->{
            try{
                    // Get the Field of the User class by the key name
                    Field field = User.class.getDeclaredField(key);
                    field.setAccessible(true); // Allow access to private fields
                    field.set(user, value);  // Set the value for the field in the user object
            }
            catch (NoSuchFieldException | IllegalAccessException e) {
                throw new AppException(ErrorCode.FIELD_NOT_EXISTED);
            }});

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUserImage(String userID, MultipartFile file)
    {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        // File is not empty
        if (file.isEmpty()) {
            throw new AppException(ErrorCode.EMPTY_FILE);
        }

        String userDir = uploadDir + File.separator + userID + File.separator ;

        File directory = new File(userDir);

        if (!directory.exists()) {
            directory.mkdirs();  // Create folder
        }

        // Create file name
        String fileName = "profile_" + userID + ".jpg";

        Path filePath = Paths.get(userDir + fileName);

        try {
            // save file
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }

        user.setImageURL(filePath.toString());

        return userMapper.toUserResponse(userRepository.save(user));
    }


}
