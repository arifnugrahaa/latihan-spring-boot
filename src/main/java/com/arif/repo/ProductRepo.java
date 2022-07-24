package com.arif.repo;

import org.springframework.data.repository.CrudRepository;

import com.arif.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
