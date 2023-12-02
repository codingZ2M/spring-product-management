package com.codingz2m.productmanagement.model;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=150)
    private String name;
    @Column(nullable=false, length=250)
    private String description;
    @Column(nullable=false, length=10)
    private BigDecimal price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductImage> images = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductReview> reviews = new HashSet<>();

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @Column(nullable=false, length=5)
    private int stockQuantity;
    @Column(nullable=false, length=6)
    private boolean isAvailable;
    
//  @JsonFormat(pattern = "2023-11-23T15:30:00")
    @Column(nullable=false, length=50)
    private LocalDateTime createdAt;
    
  //  @JsonFormat(pattern = "2023-11-23T15:30:00")
    @Column(nullable=false, length=50)
    private LocalDateTime updatedAt;
}

