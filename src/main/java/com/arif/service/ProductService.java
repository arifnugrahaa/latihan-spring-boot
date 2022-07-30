package com.arif.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arif.entity.Product;
import com.arif.repo.ProductRepo;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    @Autowired
    private EmailService emailService;

    public Iterable<Product> findAll(){
        return repo.findAll();
    }

    public void addProduct(Product product){
        emailService.sendEmail("arifnugraha1243@gmail.com", "New Product Created", "Hi, New Product is Created: "+ product.getCode()+" - "+ product.getName());
        repo.save(product);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id){
        return repo.findById(id);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }

    public List<Product> findByName(String keyword){
        return repo.findByNameContains(keyword);
    }
}
