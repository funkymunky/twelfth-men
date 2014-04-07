package net.twelfth.men.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MatchController {

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public String displayMatches(Model model) {
        return "/matches/home";
    }
}
