package com.yasmin.trabalho.crud_mongo.dtos;

import com.yasmin.trabalho.crud_mongo.domain.tasks.Status;

import java.time.LocalDate;

public record TaskRequestDTO(Long id, String name, Status status, LocalDate dayOfEnd) {

}
