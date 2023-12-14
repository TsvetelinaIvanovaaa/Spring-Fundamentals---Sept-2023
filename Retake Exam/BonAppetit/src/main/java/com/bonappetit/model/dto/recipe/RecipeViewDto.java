package com.bonappetit.model.dto.recipe;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.User;

public class RecipeViewDto {

    private Long id;

    private String name;

    private String ingredients;

    private Category category;

    private User favoriteTo;

    private User createdBy;
    public RecipeViewDto() {
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
