package dev.repositories;

import dev.entities.Cart;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,String> {
    Optional<Cart> findByUserID (String userID);

    boolean existsByUserID(String userID);
}