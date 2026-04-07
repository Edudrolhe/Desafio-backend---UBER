package com.edudrolhe.desafio_uber.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.edudrolhe.desafio_uber.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
    
}
