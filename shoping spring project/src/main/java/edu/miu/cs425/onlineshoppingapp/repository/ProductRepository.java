package edu.miu.cs425.onlineshoppingapp.repository;

import edu.miu.cs425.onlineshoppingapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
