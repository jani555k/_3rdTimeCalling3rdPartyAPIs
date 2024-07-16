package com.jr._3rdtimecalling3rdpartyapis.Controller;

import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import com.jr._3rdtimecalling3rdpartyapis.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(@Qualifier("DBService") ProductService ps) {
        this.productService = ps;
    }

    @GetMapping("/products/{ID}")
    public Product GetProductByID(@PathVariable ("ID") long ID){
        return productService.GetProductByID(ID);
    }

    @GetMapping("/products")
    public List<Product> GetALlProducts() {
        return productService.GetAllProducts();
    }

    @GetMapping("/products/categories")
    public List<String> GetAllCategories() {
        return productService.GetAllCategories();
    }

    @GetMapping("/products/category/{categoryName}")
    public List<Product> GetInCategory(@PathVariable("categoryName") String categoryName) {
        return productService.GetInCategory(categoryName);
    }

    @PostMapping("/products")
    public Product AddProduct(@RequestBody Product product) {

        return productService.AddProduct(product);
    }

    @PutMapping("/products/{productID}")
    public Product UpdateProduct(@PathVariable("productID") long productID, @RequestBody Product product) {
        return productService.UpdateProduct(productID, product);
    }

    @DeleteMapping("/products/{productID}")
    public Product DeleteProduct(@PathVariable("productID") long productID){
        return productService.DeleteProduct(productID);
    }
}