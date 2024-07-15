package com.jr._3rdtimecalling3rdpartyapis.Service;

import com.jr._3rdtimecalling3rdpartyapis.Models.Product;

import java.util.List;

public interface ProductService {
    Product GetProductByID(long ProductID);
    List<Product> GetAllProducts();
    List<String> GetAllCategories();
    List<Product> GetInCategory(String CategoryName);
    Product AddProduct(Product product);
    Product UpdateProduct(long productID, Product product);
    Product DeleteProduct(long productID);
}
