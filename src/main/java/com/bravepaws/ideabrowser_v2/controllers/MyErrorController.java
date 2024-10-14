package com.bravepaws.ideabrowser_v2.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


@Controller
public class MyErrorController implements ErrorController {
    // Описание ошибки
    private final ErrorAttributes errorAttributes;
    // Адрес странички об ошибке
    public final static String ERROR_PATH = "/error";

    // Конструктор
    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    // Подбирает параметры ошибки
    // Рисует страничку об ошибке
    @RequestMapping(value = ERROR_PATH)
    public String error(HttpServletRequest request, WebRequest webRequest, Model model) {
        Map<String, Object> body = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
        // Добавляет в модельку статус ошибки, например, "404", "500"
        model.addAttribute("status", body.get("status"));
        // Рисует страничку с ошибкой
        return "Error";
    }
}
