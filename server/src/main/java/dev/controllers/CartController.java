package dev.controllers;

import dev.dtos.requests.CartRequest;
import dev.dtos.responses.ApiResponse;
import dev.dtos.responses.CartResponse;
import dev.services.AuthenticationService;
import dev.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final AuthenticationService authService;

    public CartController(CartService cartService, AuthenticationService authService) {
        this.cartService = cartService;
        this.authService = authService;
    }

    @PostMapping()
    public ApiResponse<CartResponse> addProduct (@RequestBody CartRequest request)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("ADD PRODUCT TO CART SUCCESSFULLY")
                .data(cartService.addProduct(request,userID))
                .build();
    }

    @PutMapping()
    public ApiResponse<CartResponse> updateProduct (@RequestBody CartRequest request)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.updateProduct(request,userID))
                .build();
    }

    //Delete 1 product in cart
    @DeleteMapping("/{productID}")
    public ApiResponse<CartResponse> deleteProduct (
            @PathVariable String productID)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.deleteProduct(productID,userID))
                .build();
    }

    @GetMapping()
    public ApiResponse<CartResponse> getCart () {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.getCart(userID))
                .build();
    }


}
