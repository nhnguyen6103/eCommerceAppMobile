package javaproject.server.services;


import javaproject.server.dtos.requests.OrderItemsRequest;
import javaproject.server.dtos.requests.OrderRequest;
import javaproject.server.dtos.responses.OrderResponse;
import javaproject.server.entities.Order;
import javaproject.server.entities.OrderItem;
import javaproject.server.entities.Product;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.OrderMapper;
import jakarta.transaction.Transactional;
import javaproject.server.repositories.OrderItemsRepository;
import javaproject.server.repositories.OrderRepository;
import javaproject.server.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderItemsRepository orderItemsRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderResponse> getOrders (String userID)
    {
        List<Order> listOrder = orderRepository.findOrdersByUserID(userID);
        List<OrderResponse> response = new ArrayList<>();
        for(Order order : listOrder)
        {
            OrderResponse var = orderMapper.toOrderResponse(order);
            response.add(var);
        }
        return  response;
    }

    public OrderResponse createOrder (OrderRequest request, String userID)
    {
        Order order = orderMapper.toOrder(request,userID);
        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemsRequest item: request.getOrderItems())
        {
            Product product = productRepository.findById(item.getProductID())
                    .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

            OrderItem orderItem = OrderItem.builder()
                    .product(product)
                    .order(order)
                    .price(item.getPrice())
                    .quantity(item.getQuantity())
                    .build();

            orderItems.add(orderItem);

        }

        order.setListOrderedItems(orderItems);

        orderRepository.save(order);
        orderItemsRepository.saveAll(orderItems);

        return orderMapper.toOrderResponse(order);
    }

    public OrderResponse updateOrder (String orderID, OrderRequest request)
    {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(()-> new AppException(ErrorCode.ORDER_NOT_EXISTED));

        order.setUpdatedAt(request.getUpdateAt());
        order.setStatus(request.getStatus());

        return orderMapper.toOrderResponse(order);
    }

    @Transactional
    public void deleteOrder ( String orderID)
    {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(()-> new AppException(ErrorCode.ORDER_NOT_EXISTED));

        /*
        if (!Objects.equals(order.getUserID(), userID))
        {
            throw new AppException(ErrorCode.INVALID_ARGUMENT);
        }
        */

        orderItemsRepository.deleteByOrder(order);
        orderRepository.deleteById(orderID);
    }
}
