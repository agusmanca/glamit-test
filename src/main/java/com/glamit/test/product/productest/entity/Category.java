package com.glamit.test.product.productest.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
@Getter
@Setter
public class Category {

    @Id
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "DESCRIPTION", length = 240)
    private String description;

    @Column(name = "CODE", unique = true)
    private String code;

    public Category() {}
}
