package edu.miu.cs425.onlineshoppingapp.repository;

import edu.miu.cs425.onlineshoppingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByNameContaining(String string);
}
