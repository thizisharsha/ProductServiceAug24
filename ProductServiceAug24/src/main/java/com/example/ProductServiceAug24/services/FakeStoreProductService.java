package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(long id) {
        /*
        Take the id from input, and call
        this endpoint
        https://fakestoreapi.com/products/ + id
         */
        String url= "https://fakestoreapi.com/products/" + id;
        RestTemplate resttemplate=new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto=resttemplate.getForObject(url, FakeStoreProductDto.class);
        return convertFakeStroreProducttoProduct(fakeStoreProductDto);
    }
    private Product convertFakeStroreProducttoProduct(FakeStoreProductDto dto){
        Product product=new Product();
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setName(dto.getTitle());
        return product;
    }
}
