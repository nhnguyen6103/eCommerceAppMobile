package javaproject.server.controllers;


import javaproject.server.dtos.requests.CartRequest;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.dtos.responses.CartResponse;
import javaproject.server.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;

    }

    @PostMapping()
    public ApiResponse<CartResponse> addProduct (
            @RequestAttribute("userID") String userID,
            @RequestBody CartRequest request)
    {
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("ADD PRODUCT TO CART SUCCESSFULLY")
                .data(cartService.addProduct(request,userID))
                .build();
    }

    @PutMapping()
    public ApiResponse<CartResponse> updateProduct (
            @RequestAttribute("userID") String userID,
            @RequestBody CartRequest request)
    {
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.updateProduct(request,userID))
                .build();
    }

    //Delete 1 product in cart
    @DeleteMapping("/{productID}")
    public ApiResponse<CartResponse> deleteProduct (
            @RequestAttribute("userID") String userID,
            @PathVariable String productID)
    {
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.deleteProduct(productID,userID))
                .build();
    }

    @GetMapping()
    public ApiResponse<CartResponse> getCart (
            @RequestAttribute("userID") String userID
    ) {
        return ApiResponse.<CartResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT's QUANTITY SUCCESSFULLY")
                .data(cartService.getCart(userID))
                .build();
    }


}
