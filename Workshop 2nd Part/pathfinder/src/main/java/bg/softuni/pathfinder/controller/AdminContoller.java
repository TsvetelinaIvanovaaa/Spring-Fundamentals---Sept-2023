package bg.softuni.pathfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminContoller {

    @GetMapping("/admin")
    public ModelAndView adminPanel() {
        return new ModelAndView("");
    }
}
