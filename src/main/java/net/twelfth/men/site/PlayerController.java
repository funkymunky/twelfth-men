package net.twelfth.men.site;

import net.twelfth.men.model.Player;
import net.twelfth.men.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value="/players", method= RequestMethod.GET)
    public String getPlayerList(ModelMap model) {
        model.addAttribute("playerList", playerService.listPlayers());
        return "/players/list";
    }

    @RequestMapping(value="/players/add", method= RequestMethod.GET)
    public String addPlayer(ModelMap model) {
        model.addAttribute("player", new Player());
        return "/players/add";
    }

    @RequestMapping(value="/players/add", method= RequestMethod.POST)
    public View submitPlayer(@ModelAttribute Player player, ModelMap model) {
        if (StringUtils.hasText(player.getId())) {
            playerService.updatePlayer(player);
        } else {
            playerService.addPlayer(player);
        }
        return new RedirectView("/twelfth-men/players");
    }

    @RequestMapping(value="/playerDelete", method= RequestMethod.GET)
    public View deletePlayer(@ModelAttribute Player player, ModelMap model) {
        playerService.deletePlayer(player);
        return new RedirectView("/twelfth-men/players");
    }


}
