package com.example.ProductServiceAug24.cardinalities.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Husband {
    @Id
    long id;
    String name;
    @OneToOne
    Wife w;
}
