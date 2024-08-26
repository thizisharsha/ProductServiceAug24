package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.exceptions.productNotFoundException;

public interface ProductService {
    public Product getProductById(long id) throws productNotFoundException;
}
