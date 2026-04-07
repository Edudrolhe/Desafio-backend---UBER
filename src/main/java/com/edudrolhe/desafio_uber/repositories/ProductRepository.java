package com.edudrolhe.desafio_uber.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edudrolhe.desafio_uber.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
