package com.bonappetit.service;

import com.bonappetit.model.dto.recipe.RecipeViewDto;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.enums.CategoryNameEnum;
import com.bonappetit.model.service.RecipeServiceModel;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public RecipeService(RecipeRepository recipeRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    public void addRecipe(RecipeServiceModel recipeServiceModel) {
        Recipe recipe = modelMapper.map(recipeServiceModel, Recipe.class);
        recipe.setCreatedBy(userService.findById(loggedUser.getId()));
        recipe.setCategory(categoryService.findByCategoryNameEnum(recipeServiceModel.getCategoryName()));
        recipeRepository.save(recipe);
    }
    public List<RecipeViewDto> findAllRecipesByCategory(CategoryNameEnum categoryName){
        return recipeRepository.findByCategory_CategoryName(categoryName)
                .stream()
                .map(recipe -> modelMapper.map(recipe, RecipeViewDto.class))
                .collect(Collectors.toList());
    }

    public Long allRecipesCount() {
        return recipeRepository.count();
    }

    public void removeById(Long id) {
        recipeRepository.deleteById(id);
    }

}
