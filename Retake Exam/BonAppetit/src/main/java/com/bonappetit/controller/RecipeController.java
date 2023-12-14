package com.bonappetit.controller;

import com.bonappetit.model.dto.recipe.RecipeAddBindingModel;
import com.bonappetit.model.service.RecipeServiceModel;
import com.bonappetit.service.RecipeService;
import com.bonappetit.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public RecipeController(RecipeService recipeService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.recipeService = recipeService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }
    @ModelAttribute
    public RecipeAddBindingModel recipeAddBindingModel(){
        return new RecipeAddBindingModel();
    }
    @GetMapping("/add")
    public String addTask(){
        if(loggedUser.getId() == null){
            return "index";
        }
        return "recipe-add";
    }
    @PostMapping("/add")
    public String addTask(@Valid RecipeAddBindingModel recipeAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (loggedUser.getId() == null) {
            return "index";
        }
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("recipeAddBindingModel", recipeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipeAddBindingModel", bindingResult);
            return "redirect:add";
        }
        recipeService.addRecipe(modelMapper.map(recipeAddBindingModel, RecipeServiceModel.class));
        return "redirect:/home";
    }
}
