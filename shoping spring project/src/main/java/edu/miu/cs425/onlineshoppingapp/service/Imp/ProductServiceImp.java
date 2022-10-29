package edu.miu.cs425.onlineshoppingapp.service.Imp;

import edu.miu.cs425.onlineshoppingapp.model.Product;
import edu.miu.cs425.onlineshoppingapp.repository.ProductRepository;
import edu.miu.cs425.onlineshoppingapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return Optional.empty();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
