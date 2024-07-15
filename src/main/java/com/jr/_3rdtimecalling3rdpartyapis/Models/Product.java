package com.jr._3rdtimecalling3rdpartyapis.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long ProductID;
    private String ProductName;
    private String Description;
    private double Price;
    private String ImageURL;

    private Category category;
}
