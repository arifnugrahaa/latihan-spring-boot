package com.arif.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arif.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    

    List<Product> findByNameContains(String keyboard);
}
