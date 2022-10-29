package edu.miu.cs425.onlineshoppingapp.repository;

import edu.miu.cs425.onlineshoppingapp.model.ShoppingCart;
import edu.miu.cs425.onlineshoppingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    Optional<ShoppingCart> findByUser(User user);
}
