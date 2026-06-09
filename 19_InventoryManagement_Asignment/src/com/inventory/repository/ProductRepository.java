package com.inventory.repository;

import com.inventory.model.Product;
import java.util.List;

public interface ProductRepository {
    void save(Product product);
    Product findById(String id);
    Product findByName(String name);
    List<Product> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    boolean existsByName(String name);
}
