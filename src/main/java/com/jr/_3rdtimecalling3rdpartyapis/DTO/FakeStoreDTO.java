package com.jr._3rdtimecalling3rdpartyapis.DTO;

import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreDTO {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product ToProduct(){
        Product p = new Product();
        p.setProductName(this.title);
        p.setPrice(this.price);
        p.setDescription(this.description);
        p.setImageURL(this.image);

        Category c = new Category();
        c.setCategoryName(this.category);

        p.setCategory(c);
        return p;
    }
}





