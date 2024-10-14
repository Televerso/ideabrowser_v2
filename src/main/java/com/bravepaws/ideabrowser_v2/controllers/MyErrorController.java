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
    private final ErrorAttributes errorAttributes;
    public final static String ERROR_PATH = "/error";

    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH)
    public String error(HttpServletRequest request, WebRequest webRequest, Model model) {
        Map<String, Object> body = getErrorAttributes(request, webRequest, getTraceParameter(request));
        HttpStatus status = getStatus(request);
        model.addAttribute("status", body.get("status"));
        return "Error";
    }

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equalsIgnoreCase(parameter);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, WebRequest webRequest,
                                                   boolean includeStackTrace) {

        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults().including(includeStackTrace ? ErrorAttributeOptions.Include.STACK_TRACE : ErrorAttributeOptions.Include.STATUS));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
