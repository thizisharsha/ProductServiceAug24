package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {


    public Product getProductById(long id) throws productNotFoundException;

    public Product createProduct(String name, String category, String description);

    public Page<Product> getAllProducts(int pageSize, int pageNum);



}
