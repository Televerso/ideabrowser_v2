package com.bravepaws.ideabrowser_v2.controllers;


import com.bravepaws.ideabrowser_v2.controllers.helper.TableLine;
import com.bravepaws.ideabrowser_v2.services.IdeaService;
import com.bravepaws.ideabrowser_v2.services.ThemeService;
import com.bravepaws.ideabrowser_v2.services.UserService;
import com.bravepaws.ideabrowser_v2.services.UtiService;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private final UserService userService;
    private final IdeaService ideaService;
    private final ThemeService themeService;
    private final UtiService utiService;

    @Autowired
    public IndexController(UserService userService, IdeaService ideaService, ThemeService themeService, UtiService utiService)
    {
        this.userService = userService;
        this.ideaService = ideaService;
        this.themeService = themeService;
        this.utiService = utiService;
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<TableIdeas> ideas = ideaService.getTableIdeasList();
        List<TableLine> data = new ArrayList<>();
        for (int i = 0; i < ideas.size(); i++) {
            TableUsers user = userService.getUserById(ideas.get(i).getCustomer());
            TableThemes theme = themeService.getThemeById(ideas.get(i).getIdeaTheme());
            TableLine line = new TableLine(user, theme, ideas.get(i));
            data.add(line);
        }
        model.addAttribute("Table", data.toArray());

        return "index";
    }
    @PostMapping(path = "/save")
    public TableIdeas save(@RequestBody TableIdeas idea) {
        return ideaService.saveTableIdea(idea);
    }
    public List<TableIdeas> getTableIdeas()
    {
        return ideaService.getTableIdeasList();
    }
}

