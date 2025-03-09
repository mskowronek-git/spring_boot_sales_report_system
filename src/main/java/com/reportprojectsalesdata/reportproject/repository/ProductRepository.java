package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
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

    @Query("select p from Product p where p.name = ?1 or p.description = ?2")
    public Product findByNameOrDescriptionJPQLIndexParam(String name, String description);

    @Query("select p from Product p where p.name =:name or p.description =:description")
    public Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                         @Param("description") String description);

    @Query(value = "select * from products p where p.name = ?1 " +
            " or p.description = ?2", nativeQuery = true)
    public Product findByNameOrDescriptionSQLIndexParam(String name, String description);

    @Query(value = "select * from products p where p.name =:name " +
            " or p.description =:description", nativeQuery = true)
    public Product findByNameOrDescriptionSQLNamedParam(@Param("name") String name,
                                                         @Param("description") String description);

    public Product findBySku(String sku);
}
