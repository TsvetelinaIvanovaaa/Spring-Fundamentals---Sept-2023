package com.bonappetit.service;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.enums.CategoryNameEnum;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void initCategory() {
        if (this.categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(e -> {
                    Category category = new Category();
                    category.setCategoryName(e);
                    category.setDescription(e.getValue());

                    this.categoryRepository.save(category);
                });
    }
}
