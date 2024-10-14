package com.bravepaws.ideabrowser_v2.controllers;

import com.bravepaws.ideabrowser_v2.services.IdeaService;
import com.bravepaws.ideabrowser_v2.services.UserService;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewIdeaController {
    // Сервисы для взаимодействия с сущностями
    private final IdeaService ideaService;
    private final UserService userService;
    // Тут хранится текущий пользователь
    private TableUsers user;

    // Конструктор
    @Autowired
    public NewIdeaController(IdeaService ideaService, UserService userService) {
        this.ideaService = ideaService;
        this.userService = userService;
    }

    // Вывод формы для создания идеи при переходе на нее из странички пользователя
    // Подбирает и устанавливает текущего пользователя на переданное значение
    @RequestMapping(value = "/newidea", method = RequestMethod.POST)
    public String newIdea(Model model, @RequestParam("currUser") int currUser) {
        user = userService.getUserById(currUser);
        model.addAttribute("User", user);
        return "newidea";
    }

    // Принимает форму для создания идеи
    // Сохраняет идею в бд
    // Возвращает пользователя на его страничку
    @PostMapping(path = "/createidea")
    public String save(Model model, @RequestParam("ideaName") String ideaName, @RequestParam("Category") String Category, @RequestParam("Description") String Description) {
        // Сохранение идеи
        TableIdeas idea = new TableIdeas(ideaName, Description, Category, user.getUserId(), "active", 0);
        ideaService.saveTableIdea(idea);
        // Добавление пользователя в модель и вывод странички
        model.addAttribute("User", user);
        return "loggedinindex";
    }
}
