package com.shoppinglistapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Length(min = 3, max = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    @Length(min = 5)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    @FutureOrPresent
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
