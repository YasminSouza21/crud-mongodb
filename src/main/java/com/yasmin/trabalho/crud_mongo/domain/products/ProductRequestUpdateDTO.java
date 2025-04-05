package com.yasmin.trabalho.crud_mongo.domain.products;

public record ProductRequestUpdateDTO(Long id, String name, int quantity, double price) {
}
