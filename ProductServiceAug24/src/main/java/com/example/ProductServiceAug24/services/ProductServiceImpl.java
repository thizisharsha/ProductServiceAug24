package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dbimpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    productRepository pr;
    @Override
    public Product getProductById(long id) throws productNotFoundException {
      return  null;
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        Product p=pr.findBynameandCategory(name,category);
        if(p!=null){
            return p;
        }
        Product product=new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        product=pr.save(product);
        System.out.println(product);
        return product;
    }
}
