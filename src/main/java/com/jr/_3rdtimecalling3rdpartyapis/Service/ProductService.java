package com.jr._3rdtimecalling3rdpartyapis.Service;

import com.jr._3rdtimecalling3rdpartyapis.Exceptions.ProductNotFoundException;
import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product GetProductByID(long productID) throws ProductNotFoundException;
    List<Product> GetAllProducts();
    List<Category> GetAllCategories();
    //List<Product> GetInCategory(String CategoryName);
    Product AddProduct(Product product);
    void UpdateProduct(long ID, Product product);
    void DeleteProduct(long productID);
}
