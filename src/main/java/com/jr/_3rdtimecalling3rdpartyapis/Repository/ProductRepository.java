package com.jr._3rdtimecalling3rdpartyapis.Repository;

import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
