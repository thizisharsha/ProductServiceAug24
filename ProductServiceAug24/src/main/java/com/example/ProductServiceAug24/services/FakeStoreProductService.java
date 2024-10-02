package com.example.ProductServiceAug24.services;

import com.example.ProductServiceAug24.dtos.FakeStoreProductDto;
import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.exceptions.productNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class FakeStoreProductService implements ProductService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product getProductById(long id) throws productNotFoundException {
        /*
        Take the id from input, and call
        this endpoint
        https://fakestoreapi.com/products/ + id
         */
        Product product=(Product)this.redisTemplate.opsForHash().get("PRODUCTS","product_"+id);
        if(product!=null) {
            return product;
        }

        String url= "https://fakestoreapi.com/products/" + id;
        FakeStoreProductDto fakeStoreProductDto=this.restTemplate.getForObject(url, FakeStoreProductDto.class);
        if(fakeStoreProductDto==null){
            throw new productNotFoundException("Product with id "+id+" is not found");
        }
        product= convertFakeStoreProducttoProduct(fakeStoreProductDto);
        this.redisTemplate.opsForHash().put("PRODUCTS","products_"+id,product);
        return product;
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNo) {
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
