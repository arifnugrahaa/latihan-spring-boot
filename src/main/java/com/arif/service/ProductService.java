package com.arif.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arif.entity.Product;
import com.arif.utils.RandomNumber;

@Service
public class ProductService {
    
    public static List<Product> products = new ArrayList<Product>(){

        {
            add(new Product(RandomNumber.getRandom(1000, 9999), "001", "Product 001", 1000.0));
            add(new Product(RandomNumber.getRandom(1000, 9999), "002", "Product 002", 2000.0));
            add(new Product(RandomNumber.getRandom(1000, 9999), "003", "Product 003", 3000.0));
            add(new Product(RandomNumber.getRandom(1000, 9999), "004", "Product 004", 4000.0));
            add(new Product(RandomNumber.getRandom(1000, 9999), "005", "Product 005", 5000.0));
        }
    };

    public List<Product> findAll(){
        return products;
    }

    public void addProduct(Product product){
        product.setId(RandomNumber.getRandom(1000, 9999));
        products.add(product);
    }

    public void deleteById(long id){
        products.removeIf(p -> p.getId() == id);
    }

    public Optional<Product> findById(long id){
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void updtaeProduct(Product product){
        deleteById(product.getId());
        products.add(product);
    }
}
