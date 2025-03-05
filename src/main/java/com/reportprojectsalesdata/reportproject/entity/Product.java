package com.reportprojectsalesdata.reportproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products",
        schema = "sales_report_db",
uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",
                columnNames = "stock_keeping_unit"
        ),
        @UniqueConstraint(
                name = "name_unique",
                columnNames = "name"
        )
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
