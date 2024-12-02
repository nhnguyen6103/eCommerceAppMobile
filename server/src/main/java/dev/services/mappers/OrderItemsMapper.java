package dev.services.mappers;

import dev.dtos.responses.OrderItemsResponse;
import dev.entities.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsMapper {
    private final ProductMapper productMapper;

    public OrderItemsMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderItemsResponse toOrderItemsResponse (OrderItem item)
    {
        if(item == null)
        {
            return null;
        }
        else
        {

            OrderItemsResponse.OrderItemsResponseBuilder response = OrderItemsResponse.builder()
                    .product(productMapper.toProductResponse(item.getProduct()))
                    .price(item.getPrice())
                    .quantity(item.getQuantity());

            return response.build() ;
        }
    }

}
