package com.dictionaryapp.controller;

import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    public WordController(WordService wordService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute
    public WordAddBindingModel wordAddBindingModel() {
        return new WordAddBindingModel();
    }

    @GetMapping("/add")
    public String addTask() {

        if (loggedUser.getId() == null) {
            return "index";
        }

        return "word-add";
    }

    @PostMapping("/add")
    public String addTask(@Valid WordAddBindingModel wordAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (loggedUser.getId() == null) {
            return "index";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordAddBindingModel", wordAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel", bindingResult);

            return "redirect:add";
        }

        wordService.addWord(modelMapper.map(wordAddBindingModel, WordServiceModel.class));

        return "redirect:/home";
    }
}