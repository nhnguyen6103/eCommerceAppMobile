package dev.repositories;

import dev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(String id);

    Optional<User> findByUsername(String username);

}
