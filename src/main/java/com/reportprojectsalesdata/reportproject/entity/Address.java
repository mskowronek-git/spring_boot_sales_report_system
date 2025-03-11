package com.reportprojectsalesdata.reportproject.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
