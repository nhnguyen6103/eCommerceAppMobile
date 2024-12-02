package dev.repositories;

import dev.entities.Cart;
import dev.entities.CartItem;
import dev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItem,String> {

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
    boolean existsByCartAndProduct(Cart cart, Product product);

}
