package com.bravepaws.ideabrowser_v2.controllers;

import com.bravepaws.ideabrowser_v2.services.UserService;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class NewUserController {
    private final UserService userService;

    @Autowired
    public NewUserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String newIdea(Model model) {
        return "newuser";
    }

    @PostMapping(path = "/registeruser")
    public String save(@RequestParam("userName") String userName, @RequestParam("birthDate") Date birthDate, @RequestParam("сontactInfo") String сontactInfo) {
        TableUsers user = new TableUsers(userName, сontactInfo, birthDate);
        userService.saveUser(user);
        return "redirect:";
    }
}
