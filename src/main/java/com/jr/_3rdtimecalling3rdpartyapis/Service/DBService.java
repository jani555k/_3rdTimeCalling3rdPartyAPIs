package com.jr._3rdtimecalling3rdpartyapis.Service;

import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import com.jr._3rdtimecalling3rdpartyapis.Repository.CategoryRepository;
import com.jr._3rdtimecalling3rdpartyapis.Repository.ProductRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DBService")
public class DBService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DBService(ProductRepository pr, CategoryRepository cr) {
        this.productRepository = pr;
        this.categoryRepository = cr;
    }

    @Override
    public Product GetProductByID(long ProductID) {
        return null;
    }

    @Override
    public List<Product> GetAllProducts() {
        return List.of();
    }

    @Override
    public List<String> GetAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> GetInCategory(String CategoryName) {
        return List.of();
    }

    @Override
    public Product AddProduct(Product product) {
        Product p = new Product();
        p.setProductName(product.getProductName());
        p.setDescription(product.getDescription());
        p.setImageURL(product.getImageURL());
        p.setPrice(product.getPrice());

        Category cdb = categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
        if (cdb == null) {
            Category newc = new Category();
            newc.setCategoryName(product.getCategory().getCategoryName());
            Category newCat = categoryRepository.save(newc);
            p.setCategory(newCat);
        }
        else {
            p.setCategory(cdb);
        }

        return productRepository.save(p);
    }

    @Override
    public Product UpdateProduct(long productID, Product product) {
        return null;
    }

    @Override
    public Product DeleteProduct(long productID) {
        return null;
    }
}
