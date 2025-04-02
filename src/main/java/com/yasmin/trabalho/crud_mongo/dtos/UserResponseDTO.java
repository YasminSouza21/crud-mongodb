package com.yasmin.trabalho.crud_mongo.dtos;

import java.time.LocalDate;

public record UserResponseDTO(Long id, String name, String telephone, LocalDate birthday) {
}
