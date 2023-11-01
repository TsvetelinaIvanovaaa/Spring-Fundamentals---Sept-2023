package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.service.impl.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    private final WordService wordService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/words/add")
    public ModelAndView add(@ModelAttribute("WordAddBindingModel") WordAddBindingModel wordAddBindingModel) {
        return new ModelAndView("word-add");
    }

    @PostMapping("/words/add")
    public ModelAndView add(@ModelAttribute("WordAddBindingModel") @Valid WordAddBindingModel wordAddBindingModel,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("word-add");
        }

        wordService.add(wordAddBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/word/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        wordService.removeById(id);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/remove-all")
    public ModelAndView removeAll() {
        wordService.removeAll();

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("word/addedBy/{id}")
    public ModelAndView addedBy(@PathVariable("id") Long id) {
        wordService.addedBy(id, loggedUser.getUsername());

        return new ModelAndView("redirect:/home");
    }
}
