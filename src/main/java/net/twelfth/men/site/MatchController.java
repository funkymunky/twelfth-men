package net.twelfth.men.site;

import net.twelfth.men.model.Match;
import net.twelfth.men.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public String displayMatches(Model model) {
        model.addAttribute("matchesList", matchService.listMatches());
        return "/matches/home";
    }

    @RequestMapping(value="/matches/add", method = RequestMethod.GET)
    public String addMatch(ModelMap model) {
        model.addAttribute("match", new Match());
        return "/matches/add";
    }

    @RequestMapping(value="/matches/add", method = RequestMethod.POST)
    public View submitMatch(@ModelAttribute Match match, ModelMap model) {
        if (StringUtils.hasText(match.getId())) {
            matchService.updateMatch(match);
        } else {
            matchService.addMatch(match);
        }
        return new RedirectView("/twelfth-men/matches");
    }
}
