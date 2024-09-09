package com.example.ProductServiceAug24.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_tas")
public class Tas extends User{
    private int noOfQuestions;
    private String college;
}
