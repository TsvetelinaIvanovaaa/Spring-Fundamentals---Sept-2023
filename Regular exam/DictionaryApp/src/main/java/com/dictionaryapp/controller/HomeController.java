package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class HomeController {

    private final WordService wordService;
    private final LoggedUser loggedUser;

    public HomeController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(Model model) {

        if (loggedUser.getId() == null) {
            return new ModelAndView("index");
        }

        List<WordHomeViewModel> germanWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.GERMAN);
        List<WordHomeViewModel> spanishWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.SPANISH);
        List<WordHomeViewModel> frenchWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.FRENCH);
        List<WordHomeViewModel> italianWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.ITALIAN);

        Long allWordsCount = wordService.allWordsCount();

        model.addAttribute("germanWordsList", germanWordsList);
        model.addAttribute("spanishWordsList", spanishWordsList);
        model.addAttribute("frenchWordsList", frenchWordsList);
        model.addAttribute("italianWordsList", italianWordsList);
        model.addAttribute("allWordsCount", allWordsCount);

        return new ModelAndView("home");
    }
}
