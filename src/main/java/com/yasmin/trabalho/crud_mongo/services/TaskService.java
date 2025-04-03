package com.yasmin.trabalho.crud_mongo.services;

import com.yasmin.trabalho.crud_mongo.domain.tasks.Status;
import com.yasmin.trabalho.crud_mongo.domain.tasks.Task;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void saveTask(TaskRequestDTO taskRequestDTO){
        taskRepository.save(new Task(taskRequestDTO));
    }

    public void updateTask(TaskRequestUpdateDTO taskRequestUpdateDTO){

        Optional<Task> task = taskRepository.findById(taskRequestUpdateDTO.id());

        if(task.isPresent()){
            Task existingTask = task.get();
            existingTask.setId(taskRequestUpdateDTO.id());
            existingTask.setStatus(taskRequestUpdateDTO.status());
            existingTask.setDayOfEnd(LocalDate.parse(taskRequestUpdateDTO.dayOfEnd()));
            existingTask.setName(taskRequestUpdateDTO.name());

            taskRepository.save(existingTask);
        }
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public List<Task> listTasks(){
        return taskRepository.findAll();
    }

    public Task findTopTask(){ return taskRepository.findTopByOrderByIdDesc();}
}
