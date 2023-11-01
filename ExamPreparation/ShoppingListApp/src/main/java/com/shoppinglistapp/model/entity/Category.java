package com.shoppinglistapp.model.entity;

import com.shoppinglistapp.model.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
