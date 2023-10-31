package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
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
}
