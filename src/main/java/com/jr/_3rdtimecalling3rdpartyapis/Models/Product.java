package com.jr._3rdtimecalling3rdpartyapis.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    private String productName;
    private String Description;
    private double Price;
    private String ImageURL;
    @ManyToOne(cascade= CascadeType.PERSIST)
    private Category category;

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\''+
                ", Description='" + Description + '\''+
                ", Price=" + Price +
                ", imageUrl='" + ImageURL + '\'' +
                ", category=" + category +
                '}';
    }
}
