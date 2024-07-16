package com.jr._3rdtimecalling3rdpartyapis.Repository;

import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String categoryName);
    Category save(Category category);

}
