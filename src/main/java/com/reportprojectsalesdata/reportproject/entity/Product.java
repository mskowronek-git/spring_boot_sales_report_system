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
            @NamedNativeQuery(name = "Product.findBySku",
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

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
