package com.example.ProductServiceAug24.singleTable;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    private int id;
    private String name;
    private String email;
    private String password;


}
