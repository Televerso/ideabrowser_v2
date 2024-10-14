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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoggedInIndexController {
    // Сервисы для взаимодействия с сущностями
    private final UserService userService;
    private final IdeaService ideaService;
    private final ThemeService themeService;
    // Тут хранится текущий пользователь
    private TableUsers currUser;

    // Конструктор
    @Autowired
    public LoggedInIndexController(UserService userService, IdeaService ideaService, ThemeService themeService) {
        this.userService = userService;
        this.ideaService = ideaService;
        this.themeService = themeService;
    }

    // Вывод странички при переходе на нее из формы создания идеи
    // Забирает из модели текущего пользователя, для которого рисует страничку
    @RequestMapping(value = "/loggedinindex", method = RequestMethod.POST)
    public String loggerinindex(Model model) {
        currUser = (TableUsers) model.getAttribute("User");
        return "loggedinindex";
    }

    // Вызывается при переходе на страничку после входа
    // Устанавливает текущего пользователя на переданное значение
    // Потом рисует для него страничку
    @PostMapping(path = "/login")
    public String save(@RequestParam("login") String login, Model model) {
        currUser = userService.getUserByName(login);
        model.addAttribute("User", currUser);
        return "loggedinindex";
    }

    // Перерисовывает страничку, выводя на нее табличку для всех идей
    @PostMapping(path = "/allIdeas")
    public String allIdeas(Model model) {
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
        // Добавляем текущего пользователя и заполненную таблицу с идеями в модель
        model.addAttribute("User", currUser);
        model.addAttribute("Table", data.toArray());
        // Возвращаем страничку пользователя
        return "loggedinindex";
    }

    // Перерисовывает страничку, выводя на нее табличку для идей пользователя
    @PostMapping(path = "/myIdeas")
    public String myIdeas(Model model) {
        // Создание табички с идеями
        // Собираем все идеи для текущего пользователя
        List<TableIdeas> ideas = ideaService.getIdeasByCustomer(currUser.getUserId());
        // Создаем массив строк - саму табличку
        List<TableLine> data = new ArrayList<>();
        for (int i = 0; i < ideas.size(); i++) {
            // Заполняем табличку данными
            // Достаем из бд темы сичтывая их идентификатор из таблицы идей
            TableThemes theme = themeService.getThemeById(ideas.get(i).getIdeaTheme());
            // Закидываем строчку в массив (таблицу)
            TableLine line = new TableLine(currUser, theme, ideas.get(i));
            data.add(line);
        }
        // Добавляем текущего пользователя и заполненную таблицу с идеями в модель
        model.addAttribute("User", currUser);
        model.addAttribute("Table", data.toArray());
        // Возвращаем страничку пользователя
        return "loggedinindex";
    }
}
