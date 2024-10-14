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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    // Сервисы для взаимодействия с сущностями
    private final UserService userService;
    private final IdeaService ideaService;
    private final ThemeService themeService;

    // Конструктор
    @Autowired
    public IndexController(UserService userService, IdeaService ideaService, ThemeService themeService) {
        this.userService = userService;
        this.ideaService = ideaService;
        this.themeService = themeService;
    }

    // Вывод главной страницы
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        // Создание табички с идеями
        // Собираем все идеи из бд
        List<TableIdeas> ideas = ideaService.getTableIdeasList();
        // Создаем массив строк - саму табличку
        List<TableLine> data = new ArrayList<>();
        for (int i = 0; i < ideas.size(); i++) {
            // Заполняем табличку данными
            // Достаем из бд пользователей сичтывая их идентификатор из таблицы идей
            TableUsers user = userService.getUserById(ideas.get(i).getCustomer());
            // То же самое с темами
            TableThemes theme = themeService.getThemeById(ideas.get(i).getIdeaTheme());
            // Закидываем строчку в массив (таблицу)
            TableLine line = new TableLine(user, theme, ideas.get(i));
            data.add(line);
        }
        // Добавляем заполненную таблицу с идеями в модель
        model.addAttribute("Table", data.toArray());

        // Возвращаем главную страничку
        return "index";
    }

    // Перенаправляем запросы на "/index" в "/"
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:";
    }
}

