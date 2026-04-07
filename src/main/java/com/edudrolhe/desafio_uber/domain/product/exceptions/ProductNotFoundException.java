package com.edudrolhe.desafio_uber.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }
    
}
