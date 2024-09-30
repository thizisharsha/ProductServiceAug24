package com.example.ProductServiceAug24.repositories;

import com.example.ProductServiceAug24.models.Product;
import com.example.ProductServiceAug24.projections.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {

    //select *from products where name={name} and category={category}
    Product findByNameAndCategory(String name,String category);

    //select * from products
    List<Product> findAll();

    // select * from products where id={id}
    //Product findById(long id);

    // select * from products where category={category}
    List<Product> findByCategory(String category);

    Optional<Product> findById(long id);
    List<Product> findAllByNameLike(String word);
    List<Product> findAllByNameIgnoreCase(String word);
    List<Product> findAllByIdLessThan(long id);

    @Query(nativeQuery = true,value="select p.id,p.name,p.description from products p where id=:id")
    ProductInfo getProductInfo(long id);


    Page<Product> findAll(Pageable pageable);


}
