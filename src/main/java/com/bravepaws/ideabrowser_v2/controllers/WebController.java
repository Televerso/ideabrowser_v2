package com.bravepaws.ideabrowser_v2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:userpage";
    }
    @RequestMapping(value = "/userpage", method = RequestMethod.GET)
    public String userpage() {
        return "userpage";
    }

}