package com.kanthraju.ecom_proj.service;

import com.kanthraju.ecom_proj.model.Product;
import com.kanthraju.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts() {

        return repo.findAll();
    }

    public Product getProductById(int id) {

        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageType(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        repo.save(product);
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(Arrays.toString(imageFile.getBytes()));

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
