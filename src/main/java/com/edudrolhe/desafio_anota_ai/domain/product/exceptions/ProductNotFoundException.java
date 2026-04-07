package com.edudrolhe.desafio_anota_ai.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }
    
}
