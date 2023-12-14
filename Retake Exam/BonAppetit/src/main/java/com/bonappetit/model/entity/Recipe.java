package com.bonappetit.model.entity;

import com.bonappetit.model.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity{

    @Length(min = 2, max = 40)
    @Column(nullable = false)
    private String name;

    @Length(min = 2, max = 150)
    @Column(nullable = false)
    private String ingredients;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    private User favoriteTo;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "added_by_id")
    private User createdBy;

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getFavoriteTo() {
        return favoriteTo;
    }

    public void setFavoriteTo(User favoriteTo) {
        this.favoriteTo = favoriteTo;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
