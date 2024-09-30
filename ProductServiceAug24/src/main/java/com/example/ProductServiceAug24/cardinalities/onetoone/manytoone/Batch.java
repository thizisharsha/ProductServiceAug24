package com.example.ProductServiceAug24.cardinalities.onetoone.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Batch {
    String name;
    @Id
    long id;
}
