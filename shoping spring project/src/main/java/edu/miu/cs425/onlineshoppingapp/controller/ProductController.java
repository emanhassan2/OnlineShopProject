package edu.miu.cs425.onlineshoppingapp.controller;

import edu.miu.cs425.onlineshoppingapp.dtos.ProductDto;
import edu.miu.cs425.onlineshoppingapp.model.Product;
import edu.miu.cs425.onlineshoppingapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        var products = productService.getAllProduct();
        var productsDto = products.stream().map(a -> modelMapper.map(a, ProductDto.class)).toList();
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping(value = {"search/{productId}"})
    public Optional<Product> getProductById(@PathVariable Integer productId) {
        var product = productService.getProductById(productId)  ;
        return productService.getProductById(productId);
    }

    @GetMapping(value = {"/search"})
    public List<Product> searchProductByName(@RequestBody String name) {
        var products = productService.searchProductByName(name);
        System.out.println("name");
        return products;
    }
}
