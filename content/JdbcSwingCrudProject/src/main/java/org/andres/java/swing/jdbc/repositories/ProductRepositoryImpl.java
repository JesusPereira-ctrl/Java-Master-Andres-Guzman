package org.andres.java.swing.jdbc.repositories;

import org.andres.java.swing.jdbc.models.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
