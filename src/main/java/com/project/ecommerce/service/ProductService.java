package com.project.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;



@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id:" + id));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id,Product productDetails){
        Product product = getProductById(id);
        product.setProductname(productDetails.getProductname());
        product.setCompanyname(productDetails.getCompanyname());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setCategory(productDetails.getCategory());
        product.setReleaseDate(productDetails.getReleaseDate());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
