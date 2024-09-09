package com.example.ProductServiceAug24.repositories;

import com.example.ProductServiceAug24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {

    //select *from products where name={name} and category={category}
    Product findBynameandCategory(String name,String category);

    //select * from products
      List<Product> findAll();

    // select * from products where id={id}
    Product findById(long id);

    // select * from products where category={category}
    List<Product> findByCategory(String category);
}
