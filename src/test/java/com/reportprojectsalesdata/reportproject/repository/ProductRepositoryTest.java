package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Product;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Test
    void updateUsingSaveMethod() {

        Long id =1L;
        Product product = productRepository.findById(id).get();
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {
        Product product = new Product();
        product.setName("Galaxy 21");
        product.setDescription("Galaxy 23 desc");
        product.setSku("5");
        product.setPrice(new BigDecimal(1700));
        product.setActive(true);
        product.setImageUrl("galaxy23.png");

        Product product2 = new Product();
        product2.setName("Galaxy 20");
        product2.setDescription("Galaxy 22 desc");
        product2.setSku("6");
        product2.setPrice(new BigDecimal(1300));
        product2.setActive(true);
        product2.setImageUrl("galaxy22.png");

        productRepository.saveAll(List.of(product, product2));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        Long id = 52L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 102L;
        boolean ifExists = productRepository.existsById(id);
        System.out.println(ifExists);
    }

    @Test
     void findByName() {
        Product product = productRepository.findByName("Galaxy 21");
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescription() {
        Product product = productRepository.findByNameOrDescription("Galaxy 29", "Galaxy 22 desc");

        System.out.println(product.getName());
    }

    @Test
    void findByNameLike() {
        List<Product> productList = productRepository.findByNameLike("%Galaxy%");

        productList.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void findByDateCreatedBetween() {
        LocalDateTime startDate = LocalDateTime.of(2025, 3, 7, 10, 32, 33);
        LocalDateTime endDate = LocalDateTime.of(2025, 3, 7, 23, 32, 33);
        List<Product> productList = productRepository.findByDateCreatedBetween(startDate, endDate);

        productList.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameIn() {
        List<Product> productList = productRepository.findByNameIn(List.of("Galaxy 23" , "Galaxy 24"));

        productList.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAsc() {
        List<Product> productList = productRepository.findFirst2ByOrderByNameAsc();

        productList.forEach((p) -> {
            System.out.println(p.getName());
        });
    }
}