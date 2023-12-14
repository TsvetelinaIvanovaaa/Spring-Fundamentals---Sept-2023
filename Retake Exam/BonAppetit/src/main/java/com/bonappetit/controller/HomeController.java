package com.bonappetit.controller;

import com.bonappetit.model.dto.recipe.RecipeViewDto;
import com.bonappetit.model.enums.CategoryNameEnum;
import com.bonappetit.service.RecipeService;
import com.bonappetit.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final RecipeService recipeService;

    public HomeController(LoggedUser loggedUser, RecipeService recipeService) {
        this.loggedUser = loggedUser;
        this.recipeService = recipeService;
    }

    @GetMapping(value = {"/index", "/"})
    private String index() {
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model) {
        if (loggedUser.getId() == null) {
            return "index";
        }
        List<RecipeViewDto> mainDishList = recipeService.findAllRecipesByCategory(CategoryNameEnum.MAIN_DISH);
        List<RecipeViewDto> dessertList = recipeService.findAllRecipesByCategory(CategoryNameEnum.DESSERT);
        List<RecipeViewDto> cocktailsList = recipeService.findAllRecipesByCategory(CategoryNameEnum.COCKTAIL);

        Long allFavoriteRecipes = recipeService.allRecipesCount();

        model.addAttribute("mainDishList", mainDishList);
        model.addAttribute("dessertList", dessertList);
        model.addAttribute("cocktailsList", cocktailsList);
        model.addAttribute("allFavoriteRecipes", allFavoriteRecipes);
        return "home";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {

        if (loggedUser.getId() == null) {
            return "index";
        }

        recipeService.removeById(id);

        return "redirect:/home";
    }
    @GetMapping("/favorite-all")
    public String favoriteAll() {

        if (loggedUser.getId() == null) {
            return "index";
        }

        recipeService.allRecipesCount();

        return "redirect:/home";
    }
}
