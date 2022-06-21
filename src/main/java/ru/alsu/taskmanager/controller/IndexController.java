package ru.alsu.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ru.alsu.taskmanager.service.StatusService;

@Controller
public class IndexController {

    @Autowired
    StatusService statusService;

    @RequestMapping("/")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }
}
