package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Product;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBatchTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        Product product = new Product();
        product.setName("Galaxy 24");
        product.setDescription("Sercem urządzenia jest firmowy układ Exynos 2400 z Androidem 14 w konfiguracji 8/128 GB, 8/256 GB lub 8/512 GB");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("galaxy24.png");

        Product savedObject = productRepository.save(product);

        System.out.println(savedObject.getId());
    }
}