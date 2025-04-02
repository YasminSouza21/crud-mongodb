package com.yasmin.trabalho.crud_mongo.dtos;

public record ProductRequestUpdateDTO(Long id, String name, int quantity, double price) {
}
