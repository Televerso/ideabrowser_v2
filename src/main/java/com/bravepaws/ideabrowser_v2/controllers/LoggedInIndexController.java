package com.bravepaws.ideabrowser_v2.controllers;

import com.bravepaws.ideabrowser_v2.controllers.helper.TableLine;
import com.bravepaws.ideabrowser_v2.services.IdeaService;
import com.bravepaws.ideabrowser_v2.services.ThemeService;
import com.bravepaws.ideabrowser_v2.services.UserService;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggedInIndexController {
    private final UserService userService;
    private final IdeaService ideaService;
    private final ThemeService themeService;
    private TableUsers currUser;

    @Autowired
    public LoggedInIndexController(UserService userService, IdeaService ideaService, ThemeService themeService)
    {
        this.userService = userService;
        this.ideaService = ideaService;
        this.themeService = themeService;
    }

    @RequestMapping(value = "/loggedinindex", method = RequestMethod.POST)
    public String loggerinindex(Model model)
    {
        currUser = (TableUsers) model.getAttribute("User");
        return "loggedinindex";
    }
    @PostMapping(path = "/login")
    public String save(@RequestParam("login") String login, Model model) {
        currUser = userService.getUserByName(login);
        model.addAttribute("User", currUser);
        return "loggedinindex";
    }
    @PostMapping(path="/allIdeas")
    public String allIdeas(Model model)
    {
        List<TableIdeas> ideas = ideaService.getTableIdeasList();
        List<TableLine> data = new ArrayList<>();
        for (int i = 0; i < ideas.size(); i++) {
            TableUsers user = userService.getUserById(ideas.get(i).getCustomer());
            TableThemes theme = themeService.getThemeById(ideas.get(i).getIdeaTheme());
            TableLine line = new TableLine(user, theme, ideas.get(i));
            data.add(line);
        }
        model.addAttribute("User", currUser);
        model.addAttribute("Table", data.toArray());
        return "loggedinindex";
    }
    @PostMapping(path="/myIdeas")
    public String myIdeas(Model model)
    {
        List<TableIdeas> ideas = ideaService.getIdeasByCustomer(currUser.getUserId());
        List<TableLine> data = new ArrayList<>();
        for (int i = 0; i < ideas.size(); i++) {
            TableUsers user = userService.getUserById(ideas.get(i).getCustomer());
            TableThemes theme = themeService.getThemeById(ideas.get(i).getIdeaTheme());
            TableLine line = new TableLine(user, theme, ideas.get(i));
            data.add(line);
        }
        model.addAttribute("User", currUser);
        model.addAttribute("Table", data.toArray());
        return "loggedinindex";
    }
}
