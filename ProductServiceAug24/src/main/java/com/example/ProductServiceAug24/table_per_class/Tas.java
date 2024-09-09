package com.example.ProductServiceAug24.table_per_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_tas")
public class Tas extends User {
    private int noOfQuestions;
    private String college;
}
