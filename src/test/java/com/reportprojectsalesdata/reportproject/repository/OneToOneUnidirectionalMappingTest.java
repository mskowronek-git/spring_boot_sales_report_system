package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Address;
import com.reportprojectsalesdata.reportproject.entity.Order;
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
public class OneToOneUnidirectionalMappingTest {

    @BeforeAll
    static void setup() {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().directory("./").load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    }

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Warsaw");
        address.setStreet("Jana Pawła II");
        address.setState("Mazowieckie");
        address.setCountry("Poland");
        address.setZipCode("42-532");

        order.setBilling_address_id(address);

        orderRepository.save(order);
    }
}
