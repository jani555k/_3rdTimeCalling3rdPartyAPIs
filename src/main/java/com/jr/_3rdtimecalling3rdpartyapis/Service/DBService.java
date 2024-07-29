package com.jr._3rdtimecalling3rdpartyapis.Service;

import com.jr._3rdtimecalling3rdpartyapis.Exceptions.ProductNotFoundException;
import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import com.jr._3rdtimecalling3rdpartyapis.Repository.CategoryRepository;
import com.jr._3rdtimecalling3rdpartyapis.Repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
@Service("DBService")
public class DBService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DBService(ProductRepository pr, CategoryRepository cr) {
        this.productRepository = pr;
        this.categoryRepository = cr;
    }

    @Override
    public Product GetProductByID(long productID) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(productID);
        if (p.isPresent()) {
            return p.get();
        }

        throw new ProductNotFoundException("Product not found ra");
    }

    @Override
    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Category> GetAllCategories() {
        return categoryRepository.findAllCategories();
    }

//    @Override
//    public List<Product> GetInCategory(String categoryName) {
//        Category c = productRepository.findByCategory(categoryName);
//
//    }

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
    public void UpdateProduct(long ID, Product product) {
        Product p = productRepository.findById(ID).orElseThrow();

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

        productRepository.save(p);
    }

    @Override
    public void DeleteProduct(long productID) {
       productRepository.deleteById(productID);
    }
}
