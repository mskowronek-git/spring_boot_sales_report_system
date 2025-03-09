package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    public Product findByNameOrDescription(String name, String description);

    public Product findDistinctByName(String name);

    public Product findByPriceGreaterThan(BigDecimal price);

    public List<Product> findByNameContaining(String name);

    public List<Product> findByNameLike(String name);

    public List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    public List<Product> findByNameIn(List<String> names);

    public List<Product> findFirst2ByOrderByNameAsc();

}
