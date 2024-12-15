package javaproject.server.mappers;


import javaproject.server.dtos.requests.OrderRequest;
import javaproject.server.dtos.responses.OrderItemsResponse;
import javaproject.server.dtos.responses.OrderResponse;
import javaproject.server.entities.Order;
import javaproject.server.entities.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapper {
    private final OrderItemsMapper orderItemsMapper;

    public OrderMapper(OrderItemsMapper orderItemsMapper) {
        this.orderItemsMapper = orderItemsMapper;
    }

    public OrderResponse toOrderResponse(Order order)
    {
        if(order == null)
        {
            return  null;
        }

        List<OrderItemsResponse> list = new ArrayList<>();
        for(OrderItem item : order.getListOrderedItems())
        {
            list.add(orderItemsMapper.toOrderItemsResponse(item));
        }


        OrderResponse.OrderResponseBuilder response = OrderResponse
                    .builder()
                    .id(order.getId())
                    .status(order.getStatus())
                    .total(order.getTotal())
                    .createdAt(order.getCreatedAt())
                    .updatedAt(order.getUpdatedAt())
                    .shipping_address(order.getShippingAddress())
                    .shippingMethod(order.getShippingMethod())
                    .paymentMethod(order.getPaymentMethod())
                    .orderedItems(list);

        return response.build();
    }

    public Order toOrder(OrderRequest request, String userID)
    {
        if(request == null)
        {
            return  null;
        }

        Order.OrderBuilder order = Order
                .builder()
                .userID(userID)
                .total(request.getTotal())
                .status(request.getStatus())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdateAt())
                .shippingMethod(request.getShippingMethod())
                .paymentMethod(request.getPaymentMethod())
                .shippingAddress(request.getShippingAddress());

        return order.build();
    }

}
