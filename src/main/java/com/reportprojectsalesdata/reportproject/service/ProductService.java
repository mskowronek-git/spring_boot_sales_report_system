package com.reportprojectsalesdata.reportproject.service;

import com.reportprojectsalesdata.reportproject.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
