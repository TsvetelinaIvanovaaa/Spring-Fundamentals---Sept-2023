package com.bonappetit.repo;

import com.bonappetit.model.entity.BaseEntity;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(CategoryNameEnum categoryName);
}
