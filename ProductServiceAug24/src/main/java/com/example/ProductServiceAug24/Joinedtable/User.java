package com.example.ProductServiceAug24.Joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_users")
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;


}
