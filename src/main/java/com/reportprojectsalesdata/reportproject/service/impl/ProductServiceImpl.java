package com.reportprojectsalesdata.reportproject.service.impl;

import com.reportprojectsalesdata.reportproject.entity.Product;
import com.reportprojectsalesdata.reportproject.repository.ProductRepository;
import com.reportprojectsalesdata.reportproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
