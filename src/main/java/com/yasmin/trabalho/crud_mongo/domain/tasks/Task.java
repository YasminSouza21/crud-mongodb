package com.yasmin.trabalho.crud_mongo.domain.tasks;

import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.ProductRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestDTO;
import com.yasmin.trabalho.crud_mongo.dtos.TaskRequestUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "tasks")
public class Task {
    @Id
    private ObjectId objectId;
    private Long id;
    private String name;
    private Status status;
    private LocalDate dayOfEnd;

    public Task(TaskRequestDTO taskRequestDTO) {
        this.id = taskRequestDTO.id();
        this.name = taskRequestDTO.name();
        this.status = taskRequestDTO.status();
        this.dayOfEnd = taskRequestDTO.dayOfEnd();
    }

    public Task(TaskRequestUpdateDTO taskRequestUpdateDTO) {
        this.id = taskRequestUpdateDTO.id();
        this.name = taskRequestUpdateDTO.name();
        this.status = taskRequestUpdateDTO.status();
        this.dayOfEnd = LocalDate.parse(taskRequestUpdateDTO.dayOfEnd());
    }

}

