package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.model.dto.word.WordViewDto;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    public HomeController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }
    @GetMapping(value = {"/index", "/"})
    private String index(){
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model){
        if(loggedUser.getId() == null){
            return "index";
        }
        List<WordViewDto> germanWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.GERMAN);
        List<WordViewDto> spanishWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.SPANISH);
        List<WordViewDto> frenchWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.FRENCH);
        List<WordViewDto> italianWordsList = wordService.findAllWordsByLanguage(LanguageNameEnum.ITALIAN);

        Long allWordsCount = wordService.allWordsCount();

        model.addAttribute("germanWordsList", germanWordsList);
        model.addAttribute("spanishWordsList", spanishWordsList);
        model.addAttribute("frenchWordsList", frenchWordsList);
        model.addAttribute("italianWordsList", italianWordsList);
        model.addAttribute("allWordsCount", allWordsCount);

        return "home";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {

        if (loggedUser.getId() == null) {
            return "index";
        }

        wordService.removeById(id);

        return "redirect:/home";
    }

    @GetMapping("/remove-all")
    public String removeAll() {

        if (loggedUser.getId() == null) {
            return "index";
        }

        wordService.removeAll();

        return "redirect:/home";
    }
}
