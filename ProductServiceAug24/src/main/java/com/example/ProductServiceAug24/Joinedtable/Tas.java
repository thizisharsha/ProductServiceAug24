package com.example.ProductServiceAug24.Joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name = "user_id")
public class Tas extends User {
    private int noOfQuestions;
    private String college;
}
