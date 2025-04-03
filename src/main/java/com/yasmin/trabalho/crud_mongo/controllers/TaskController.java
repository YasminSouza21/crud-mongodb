package com.yasmin.trabalho.crud_mongo.controllers;

import com.yasmin.trabalho.crud_mongo.domain.tasks.Status;
import com.yasmin.trabalho.crud_mongo.domain.tasks.Task;
import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ModelAndView home(ModelAndView mv) {
        Task task = taskService.findTopTask();

        if (task != null) {
            long currentId = task.getId() + 1;

            mv.addObject("taskRequestDTO", new TaskRequestDTO(currentId, "", Status.PENDENTE, LocalDate.now()));
        } else {
            mv.addObject("taskRequestDTO", new TaskRequestDTO(1L, "", Status.PENDENTE, LocalDate.now()));
        }

        mv.addObject("taskRequestUpdateDTO", new TaskRequestUpdateDTO(0L, "", Status.PENDENTE, LocalDate.now().toString()));

        List<Task> tasks = taskService.listTasks();

        List<Status> status = Arrays.stream(Status.values()).toList();

        mv.addObject("tasks", tasks);

        mv.addObject("listStatus", status);

        return mv;
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("taskRequestDTO") TaskRequestDTO taskRequestDTO) {
        taskService.saveTask(taskRequestDTO);
        return "redirect:/home?page=tasks";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("taskRequestUpdateDTO") TaskRequestUpdateDTO taskRequestUpdateDTO){
        taskService.updateTask(taskRequestUpdateDTO);
        return "redirect:/home?page=tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/home?page=tasks";
    }

}