package javaproject.server.controllers;


import javaproject.server.dtos.requests.OrderRequest;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.dtos.responses.OrderResponse;
import javaproject.server.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ApiResponse<List<OrderResponse>> getOrders (@RequestAttribute("userID") String userID)
    {

        return ApiResponse.<List<OrderResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Success")
                .data(orderService.getOrders(userID))
                .build();
    }

    @PostMapping()
    public ApiResponse<OrderResponse> createOrder(
            @RequestAttribute("userID") String userID,
            @RequestBody OrderRequest request)
    {
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