package com.yasmin.trabalho.crud_mongo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    private ProductController productController;
    private UserController userController;
    private TaskController taskController;

    public HomeController(ProductController productController, UserController userController, TaskController taskController) {
        this.productController = productController;
        this.userController = userController;
        this.taskController = taskController;
    }

    @GetMapping("")
    public ModelAndView home(@RequestParam(value = "page", required = false, defaultValue = "") String page) {
        ModelAndView mv = new ModelAndView("index");

        System.out.println(page);

        mv.addObject("page", page);

        switch (page) {
            case "users":
                userController.home(mv);
                break;

            case "products":
                productController.home(mv);
                break;

            case "tasks":
                taskController.home(mv);
                break;

            default:
                mv.addObject("message", "Página não encontrada");
                break;
        }

        return mv;
    }
}