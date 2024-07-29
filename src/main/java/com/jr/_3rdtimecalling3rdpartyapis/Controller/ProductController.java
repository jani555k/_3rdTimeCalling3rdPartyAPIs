package com.jr._3rdtimecalling3rdpartyapis.Controller;

import com.jr._3rdtimecalling3rdpartyapis.DTO.ErrorDTO;
import com.jr._3rdtimecalling3rdpartyapis.Exceptions.ProductNotFoundException;
import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import com.jr._3rdtimecalling3rdpartyapis.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(@Qualifier("FakeStoreService") ProductService ps) {
        this.productService = ps;
    }

    @GetMapping("/products/{ID}")
    public ResponseEntity<Product> GetProductByID(@PathVariable ("ID") long ID) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.GetProductByID(ID));
    }

    @GetMapping("/products")
    public List<Product> GetALlProducts() {
        return productService.GetAllProducts();
    }

    @GetMapping("/products/categories")
    public List<Category> GetAllCategories() {
        return productService.GetAllCategories();
    }

//    @GetMapping("/products/category/{categoryName}")
//    public List<Product> GetInCategory(@PathVariable("categoryName") String categoryName) {
//        return productService.GetInCategory(categoryName);
//    }

    @PostMapping("/products")
    public Product AddProduct(@RequestBody Product product) {

        return productService.AddProduct(product);
    }

    @PutMapping("/products/{productID}")
    public void UpdateProduct(@PathVariable("productID") long productID, @RequestBody Product product) {
        productService.UpdateProduct(productID, product);
    }

    @DeleteMapping("/products/{productID}")
    public void DeleteProduct(@PathVariable("productID") long productID){
        productService.DeleteProduct(productID);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDTO> handleProductNotFoundException(Exception e) {
//        ErrorDTO errorDto = new ErrorDTO();
//        errorDto.setMessage(e.getMessage());
//
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    }
}