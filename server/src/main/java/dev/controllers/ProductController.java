package dev.controllers;

import dev.dtos.requests.ProductRequest;
import dev.dtos.responses.ApiResponse;
import dev.dtos.responses.ProductResponse;
import dev.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAll ()
    {
        return ApiResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("GET PRODUCTS SUCCESSFULLY")
                .data(productService.getAll())
                .build();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<ProductResponse> createProduct(
            @RequestBody ProductRequest request)
    {
        return ApiResponse.<ProductResponse>builder()
                .status(HttpStatus.OK.value())
                .message("CREATE PRODUCT SUCCESSFULLY")
                .data(productService.createProduct(request))
                .build();
    }

    @PutMapping("/{productID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<ProductResponse> updateProductImage( @PathVariable String productID,
                                                            @RequestParam("image") MultipartFile file)
    {
        return ApiResponse.<ProductResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT'S IMAGE SUCCESSFULLY")
                .data(productService.updateProductImage(productID,file))
                .build();
    }

    @PatchMapping("/{productID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<ProductResponse> updateProductDetails(@PathVariable String productID,
                                                             @RequestBody Map<String,String> updateFields)
    {
        return ApiResponse.<ProductResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE PRODUCT DETAILS SUCCESSFULLY")
                .data(productService.updateProductDetails(productID,updateFields))
                .build();
    }

    @DeleteMapping("/{productID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<?> deleteProduct(@PathVariable String productID)
    {
        productService.deleteProduct(productID);

        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("DELETE PRODUCT SUCCESSFULLY")
                .build();
    }
}
