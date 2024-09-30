package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import com.example.ProductServiceAug24.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbimpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    productRepository pr;
    @Override
    public Product getProductById(long id) throws productNotFoundException {
        ProductInfo productinfo=pr.getProductInfo(id);
        System.out.println(productinfo.getDescription());
        System.out.println(productinfo.getName());
        System.out.println(productinfo.getId());
        Optional<Product> op= pr.findById(id);
        if(op.isPresent()){
            Product product=op.get();
            return product;
        }
        else {
            throw  new productNotFoundException("Product with id:"+id+" is not available");
        }
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        Product p=pr.findByNameAndCategory(name,category);
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

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return pr.findAll(PageRequest.of(pageNum, pageSize,Sort.by("category").descending()));
    }


}
