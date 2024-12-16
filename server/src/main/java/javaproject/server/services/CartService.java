package javaproject.server.services;


import javaproject.server.dtos.requests.CartRequest;
import javaproject.server.dtos.responses.CartItemsResponse;
import javaproject.server.dtos.responses.CartResponse;
import javaproject.server.entities.Cart;
import javaproject.server.entities.CartItem;
import javaproject.server.entities.Product;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.CartItemsMapper;
import javaproject.server.repositories.CartItemsRepository;
import javaproject.server.repositories.CartRepository;
import javaproject.server.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemsRepository cartItemsRepository;
    private final CartItemsMapper cartItemsMapper;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemsRepository cartItemsRepository, CartItemsMapper cartItemsMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemsRepository = cartItemsRepository;
        this.cartItemsMapper = cartItemsMapper;
    }

    //add 1 product to cart
    public CartResponse addProduct (CartRequest request, String userID)
    {
        //check cart existed
        Cart cart = cartRepository.findByUserID(userID)
                .orElseThrow(()-> new AppException(ErrorCode.CART_NOT_EXISTED));

        //check product existed
        Product product = productRepository.findById(request.getProductID())
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED_IN_CART));

        //check quantity
        if(product.getQuantity() < request.getQuantity())
        {
           throw new AppException(ErrorCode.INVALID_ARGUMENT);
        }

        CartItem cartItem = new CartItem();
        //if product already existed in cart
        if(cartItemsRepository.existsByCartAndProduct(cart,product))
        {
            cartItem = cartItemsRepository.findByCartAndProduct(cart,product).get();
        }
        else //if not
        {
            cartItem.setCart(cart);
            cartItem.setProduct(product);
        }
        cartItem.setQuantity(request.getQuantity());
        cartItemsRepository.save(cartItem);

        //Add to cart
        cart.getSetProduct().add(cartItem);

        //Create list response
        List<CartItemsResponse> list = new ArrayList<>();
        for(CartItem item : cart.getSetProduct())
        {
            list.add(cartItemsMapper.toCartItemsResponse(item));
        }

        return CartResponse.builder()
                .cartID(cart.getId())
                .quantity(list.size())
                .listItems(list)
                .build();
    }

    //Update 1 product in cart
    public CartResponse updateProduct (CartRequest request, String userID)
    {
        //check cart existed
        Cart cart = cartRepository.findByUserID(userID)
                .orElseThrow(()-> new AppException(ErrorCode.CART_NOT_EXISTED));

        //check product existed
        Product product = productRepository.findById(request.getProductID())
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED_IN_CART));

        //check quantity
        if(product.getQuantity() < request.getQuantity())
        {
            throw new AppException(ErrorCode.INVALID_ARGUMENT);
        }

        CartItem cartItem = cartItemsRepository.findByCartAndProduct(cart,product)
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED_IN_CART));

        cartItem.setQuantity(request.getQuantity());

        cartItemsRepository.save(cartItem);

        //Create list response
        List<CartItemsResponse> list = new ArrayList<>();
        for(CartItem item : cart.getSetProduct())
        {
            list.add(cartItemsMapper.toCartItemsResponse(item));
        }

        return CartResponse.builder()
                .cartID(cart.getId())
                .quantity(list.size())
                .listItems(list)
                .build();
    }

    //Delete 1 product in cart
    public CartResponse deleteProduct (String productID, String userID)
    {
        //check cart existed
        Cart cart = cartRepository.findByUserID(userID)
                .orElseThrow(()-> new AppException(ErrorCode.CART_NOT_EXISTED));

        //check product existed
        Product product = productRepository.findById(productID)
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED_IN_CART));

        //check cartItems
        CartItem cartItem = cartItemsRepository.findByCartAndProduct(cart,product)
                .orElseThrow(()-> new AppException(ErrorCode.NOT_EXISTED_IN_CART));

        cartItemsRepository.delete(cartItem);

        cart.getSetProduct().remove(cartItem);

        //Create list response
        List<CartItemsResponse> list = new ArrayList<>();
        for(CartItem item : cart.getSetProduct())
        {
            list.add(cartItemsMapper.toCartItemsResponse(item));
        }
        return CartResponse.builder()
                .cartID(cart.getId())
                .quantity(list.size())
                .listItems(list)
                .build();
    }


    public CartResponse getCart ( String userID )
    {
        //Check cart existed
        Cart cart = cartRepository.findByUserID(userID)
                .orElseThrow(()-> new AppException(ErrorCode.CART_NOT_EXISTED));

        //Create list response
        List<CartItemsResponse> list = new ArrayList<>();
        for(CartItem item : cart.getSetProduct())
        {
            list.add(cartItemsMapper.toCartItemsResponse(item));
        }

        return CartResponse.builder()
                .cartID(cart.getId())
                .quantity(list.size())
                .listItems(list)
                .build();
    }


}
