package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Product;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.datasource.url=${DB_URL}",
        "spring.datasource.username=${DB_USERNAME}",
        "spring.datasource.password=${DB_PASSWORD}"
})
class ProductRepositoryTest {

    @BeforeAll
    static void setup() {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().directory("./").load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    }

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        Product product = new Product();
        product.setName("dfg");
        product.setDescription("dfg");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("galaxy24.png");

        Product savedObject = productRepository.save(product);

        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
}