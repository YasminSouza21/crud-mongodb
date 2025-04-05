package com.yasmin.trabalho.crud_mongo.domain.tasks;

public record TaskRequestUpdateDTO(Long id, String name, Status status, String dayOfEnd) {
}
