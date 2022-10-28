package edu.miu.cs425.onlineshoppingapp.service;

import edu.miu.cs425.onlineshoppingapp.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(Integer productId);
    public Optional<Product> getProductByName(String productName);
    public List<Product> searchProductByName(String name);
}
