package com.example.ProductServiceAug24.singleTable;

import lombok.Data;

@Data
public class Mentor extends User {
    private double avg_rating;
    private String curr_company;
}
