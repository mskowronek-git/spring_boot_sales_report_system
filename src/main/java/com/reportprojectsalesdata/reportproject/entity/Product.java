package com.reportprojectsalesdata.reportproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries(
        {
            @NamedQuery(name = "Product.findBySku",
                    query = "SELECT p from Product p WHERE p.sku =:sku"
            ),
            @NamedQuery(name = "Product.findByPrice",
            query = "SELECT p from Product p WHERE p.price =:price"
            )
        }
)
@NamedNativeQueries(
        {
            @NamedNativeQuery(name = "Product.findBySkuNative",
                    query = "SELECT * from PRODUCTS WHERE p.sku =:sku",
                    resultClass = Product.class)
        }
)

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "product_generator")

    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name"
    )
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
