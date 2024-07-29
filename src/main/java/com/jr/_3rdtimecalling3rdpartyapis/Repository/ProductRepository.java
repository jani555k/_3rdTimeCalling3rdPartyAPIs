package com.jr._3rdtimecalling3rdpartyapis.Repository;

import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Optional<Product> findById(long productId);
    //List<Product> findByCategory(String categoryName);
}
