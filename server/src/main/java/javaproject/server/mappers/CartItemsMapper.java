package javaproject.server.mappers;

import javaproject.server.dtos.responses.CartItemsResponse;
import javaproject.server.entities.CartItem;
import org.springframework.stereotype.Service;

@Service
public class CartItemsMapper {
    private final ProductMapper productMapper;

    public CartItemsMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public CartItemsResponse toCartItemsResponse (CartItem cartItem)
    {
        if(cartItem == null)
        {
            return null;
        }
        else
        {
            CartItemsResponse.CartItemsResponseBuilder response = CartItemsResponse.builder()
                    .product(productMapper.toProductResponse(cartItem.getProduct()))
                    .quantity(cartItem.getQuantity());

            return response.build();
        }
    }
}
