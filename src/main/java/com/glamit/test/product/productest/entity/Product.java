package com.glamit.test.product.productest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME", length = 240)
    private String name;

    @Column(name = "CATEGORY_ID")
    private Long category;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "IMG_URL")
    private String imgUrl;

    @Column(name = "SKU", unique = true)
    private String sku;

    public Product() {}
}
