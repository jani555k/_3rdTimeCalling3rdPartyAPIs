package com.jr._3rdtimecalling3rdpartyapis.Service;

import com.jr._3rdtimecalling3rdpartyapis.DTO.FakeStoreDTO;
import com.jr._3rdtimecalling3rdpartyapis.Exceptions.ProductNotFoundException;
import com.jr._3rdtimecalling3rdpartyapis.Models.Category;
import com.jr._3rdtimecalling3rdpartyapis.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreService implements ProductService{

    private final RestTemplate restTemplate;
    public FakeStoreService(RestTemplate rt) {
        this.restTemplate = rt;
    }

    @Override
    public Product GetProductByID(long productID) throws ProductNotFoundException {
        FakeStoreDTO fakeStoreDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + productID, FakeStoreDTO.class);

            return fakeStoreDTO.ToProduct();
    }

    @Override
    public List<Product> GetAllProducts() {
        FakeStoreDTO[] fakeStoreDTO = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreDTO[].class);
        List<Product> products = new ArrayList<>();
        assert fakeStoreDTO != null;
        for(FakeStoreDTO fakeStoreDTO1 : fakeStoreDTO) {
            products.add(fakeStoreDTO1.ToProduct());
        }
        return products;
    }

    @Override
    public List<Category> GetAllCategories() {
        return null;
        //return restTemplate.getForObject("https://fakestoreapi.com/products/categories/", List.class);
    }

//    @Override
//    public List<Product> GetInCategory(String categoryName) {
//        FakeStoreDTO[] p = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + categoryName, FakeStoreDTO[].class);
//        List<Product> products = new ArrayList<>();
//        assert p != null;
//        for(FakeStoreDTO p1 : p) {
//            products.add(p1.ToProduct());
//        }
//        return products;
//    }

    @Override
    public Product AddProduct(Product p) {
        FakeStoreDTO fs = new FakeStoreDTO();
        fs.setImage(p.getImageURL());
        fs.setDescription(p.getDescription());
        fs.setPrice(p.getPrice());
        fs.setTitle(p.getProductName());
        fs.setCategory(p.getCategory().getCategoryName());

        FakeStoreDTO fsDTO =  restTemplate.postForObject("https://fakestoreapi.com/products/", fs, FakeStoreDTO.class);

        assert fsDTO != null;
        return fsDTO.ToProduct();
    }

    @Override
    public void UpdateProduct(long productID, Product p) {
        FakeStoreDTO fs = new FakeStoreDTO();
        fs.setImage(p.getImageURL());
        fs.setDescription(p.getDescription());
        fs.setPrice(p.getPrice());
        fs.setTitle(p.getProductName());
        fs.setCategory(p.getCategory().getCategoryName());

      restTemplate.put("https://fakestoreapi.com/products/" + productID, fs);
    }

    @Override
    public void DeleteProduct(long productID) {
        restTemplate.delete("https://fakestoreapi.com/products/" + productID);
    }
}
