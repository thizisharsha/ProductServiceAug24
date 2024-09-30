package com.example.ProductServiceAug24.cardinalities.onetoone.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Learner {
    @Id
    int id;
    String name;
    @ManyToOne
    Batch b;
}
