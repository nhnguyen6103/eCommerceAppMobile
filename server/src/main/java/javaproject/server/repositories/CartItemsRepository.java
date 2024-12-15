package javaproject.server.repositories;


import javaproject.server.entities.Cart;
import javaproject.server.entities.CartItem;
import javaproject.server.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItem,String> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    boolean existsByCartAndProduct(Cart cart, Product product);

}
