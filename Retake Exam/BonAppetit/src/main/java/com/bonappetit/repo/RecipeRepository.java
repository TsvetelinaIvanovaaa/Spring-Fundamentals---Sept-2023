package com.bonappetit.repo;

import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByCategory_CategoryName(CategoryNameEnum categoryName);
}
