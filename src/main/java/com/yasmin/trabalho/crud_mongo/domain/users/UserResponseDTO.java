package com.yasmin.trabalho.crud_mongo.domain.users;

import java.time.LocalDate;

public record UserResponseDTO(Long id, String name, String telephone, LocalDate birthday) {
}
