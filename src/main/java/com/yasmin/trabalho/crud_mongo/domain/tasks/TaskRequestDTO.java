package com.yasmin.trabalho.crud_mongo.domain.tasks;

import java.time.LocalDate;

public record TaskRequestDTO(Long id, String name, Status status, LocalDate dayOfEnd) {

}
