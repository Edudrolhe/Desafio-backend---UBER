package com.edudrolhe.desafio_anota_ai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edudrolhe.desafio_anota_ai.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
