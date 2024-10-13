package com.bravepaws.ideabrowser_v2.controllers;

import com.bravepaws.ideabrowser_v2.services.IdeaService;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewIdeaController {
    private final IdeaService ideaService;
    @Autowired
    public NewIdeaController(IdeaService ideaService)
    {
        this.ideaService = ideaService;
    }

    @RequestMapping(value = "/newidea", method = RequestMethod.GET)
    public String newIdea(Model model)
    {
        return "newidea";
    }
    @PostMapping(path = "/createidea")
    public String save(@RequestParam("ideaName") String ideaName, @RequestParam("Category") String Category, @RequestParam("Description") String Description) {
        TableIdeas idea = new TableIdeas(ideaName,Description,Category,0,"active",0);
        ideaService.saveTableIdea(idea);
        return "redirect:/";
    }
}
