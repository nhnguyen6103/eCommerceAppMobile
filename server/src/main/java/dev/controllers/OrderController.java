package dev.controllers;

import dev.dtos.requests.OrderRequest;
import dev.dtos.responses.ApiResponse;
import dev.dtos.responses.OrderResponse;
import dev.services.AuthenticationService;
import dev.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final AuthenticationService authService;

    public OrderController(OrderService orderService, AuthenticationService authService) {
        this.orderService = orderService;
        this.authService = authService;
    }

    @GetMapping()
    public ApiResponse<List<OrderResponse>> getOrders ()
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<List<OrderResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Success")
                .data(orderService.getOrders(userID))
                .build();
    }

    @PostMapping()
    public ApiResponse<OrderResponse> createOrder(@RequestBody OrderRequest request)
    {
        String userID = authService.getIdFromAuthentication();
        return ApiResponse.<OrderResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("CREATE SUCCESS")
                .data(orderService.createOrder(request,userID))
                .build();
    }

    @PutMapping("/{orderID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<OrderResponse> updateOrder(@PathVariable String orderID,
                                                 @RequestBody OrderRequest request)
    {
        return ApiResponse.<OrderResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE SUCCESSFULLY")
                .data(orderService.updateOrder(orderID,request))
                .build();
    }

    @DeleteMapping("/{orderID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<?> deleteOrder(@PathVariable String orderID)
    {
        orderService.deleteOrder(orderID);
        return ApiResponse.<OrderResponse>builder()
                .status(HttpStatus.OK.value())
                .message("DELETE SUCCESSFULLY")
                .build();
    }

}