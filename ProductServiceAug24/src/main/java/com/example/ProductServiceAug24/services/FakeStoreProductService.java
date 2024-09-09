package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service("fakeStore")
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(long id) throws productNotFoundException {
        /*
        Take the id from input, and call
        this endpoint
        https://fakestoreapi.com/products/ + id
         */
        String url= "https://fakestoreapi.com/products/" + id;
        RestTemplate resttemplate=new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto=resttemplate.getForObject(url, FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw new productNotFoundException("Product with id "+id+" is not found");
        }
        return convertFakeStoreProducttoProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        return null;
    }

    private Product convertFakeStoreProducttoProduct(FakeStoreProductDto dto){
        Product product=new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}
