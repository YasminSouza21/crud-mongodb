package com.yasmin.trabalho.crud_mongo.controllers;

import com.yasmin.trabalho.crud_mongo.domain.users.User;
import com.yasmin.trabalho.crud_mongo.domain.users.UserRequestCreateDTO;
import com.yasmin.trabalho.crud_mongo.domain.users.UserRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView home(ModelAndView mv){

        User user = userService.findUserTopId();

        if(user != null){
            long currentId = user.getId() + 1;
            mv.addObject("userRequestCreateDTO",new UserRequestCreateDTO(currentId, "", "", LocalDate.now()));
        } else {
            mv.addObject("userRequestCreateDTO",new UserRequestCreateDTO(1L, "", "", LocalDate.now()));
        }

        mv.addObject("userRequestUpdateDTO", new UserRequestUpdateDTO(0L, "", "", LocalDate.now().toString()));

        List<User> users = userService.findUsers();

        if(users != null){
            mv.addObject("users", users);

        }

        return mv;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userRequestCreateDTO") UserRequestCreateDTO userRequestDTO, RedirectAttributes redirectAttributes){

        userService.saveUser(userRequestDTO);
        ModelAndView mv = new ModelAndView("index");

        mv.addObject("users", userService.findUsers());

        redirectAttributes.addFlashAttribute("successMessage", "Usuário adicionado com sucesso!");

        return "redirect:/home?page=users";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("userRequestUpdateDTO") UserRequestUpdateDTO userRequestUpdateDTO, RedirectAttributes redirectAttributes) {
        System.out.println(userRequestUpdateDTO.name());
        userService.updateUser(userRequestUpdateDTO);

        redirectAttributes.addFlashAttribute("successMessage", "Usuário atualizado com sucesso!");

        return "redirect:/home?page=users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes){
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("successMessage", "Usuário excluído com sucesso!");
        return "redirect:/home?page=users";
    }
}
