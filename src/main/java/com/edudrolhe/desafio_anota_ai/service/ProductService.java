package com.edudrolhe.desafio_anota_ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edudrolhe.desafio_anota_ai.domain.category.Category;
import com.edudrolhe.desafio_anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.edudrolhe.desafio_anota_ai.domain.product.Product;
import com.edudrolhe.desafio_anota_ai.domain.product.ProductDTO;
import com.edudrolhe.desafio_anota_ai.domain.product.exceptions.ProductNotFoundException;
import com.edudrolhe.desafio_anota_ai.repositories.ProductRepository;

@Service
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final SmsMockService smsService;
    private final String adminPhoneNumber;

    public ProductService(CategoryService categoryService,
                          ProductRepository productRepository,
                          SmsMockService smsService,
                          @Value("${app.notification.phone}") String adminPhoneNumber) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.smsService = smsService;
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public Product insert(ProductDTO productData){
        Category category = this.categoryService.getById(productData.categoryId())
                .orElseThrow(CategoryNotFoundException::new);           
        Product newProduct = new Product(productData);
        newProduct.setCategory(category);
        this.productRepository.save(newProduct);  

        // Notificação: Produto criado

        String message = String.format("NOVO PRODUTO CRIADO!%nNome: %s%nPreço: R$ %d%nCategoria: %s", 
                newProduct.getTitle(), newProduct.getPrice(), category.getTitle());
                smsService.sendSms(adminPhoneNumber, message);
        return newProduct;
    };

    public Product update(String id, ProductDTO productData){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        String oldTitle = product.getTitle();

        if(productData.title() != null && !productData.title().isEmpty())
            product.setTitle(productData.title());

        if(productData.description() != null && !productData.description().isEmpty())
            product.setDescription(productData.description());

        if(productData.price() != null)
            product.setPrice(productData.price());

        this.productRepository.save(product);

        // Notificação: Produto atualizado
        String message = String.format("PRODUTO ATUALIZADO!%nID: %s%nAntigo: %s%nNovo: %s",
                id, oldTitle, product.getTitle());
        smsService.sendSms(adminPhoneNumber, message);

        return product;
    }

    public void delete(String id){
        Product product = this.productRepository.findById(id)  
                .orElseThrow(ProductNotFoundException::new);  

        this.productRepository.delete(product);  

        // Notificação: Produto deletado
        String message = String.format("PRODUTO DELETADO!%nID: %s%nNome: %s", id, product.getTitle());
        smsService.sendSms(adminPhoneNumber, message);
        
    }
    
    public List<Product> getAll(){
        return this.productRepository.findAll();  
    }
    
}