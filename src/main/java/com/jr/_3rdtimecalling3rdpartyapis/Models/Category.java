package com.jr._3rdtimecalling3rdpartyapis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    private String categoryName;
    @OneToMany(mappedBy= "category", cascade= CascadeType.REMOVE)
    @JsonIgnore
    private List<Product> Products;
}
