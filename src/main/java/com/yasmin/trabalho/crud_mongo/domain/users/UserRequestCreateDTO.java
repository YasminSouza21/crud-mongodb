package com.yasmin.trabalho.crud_mongo.domain.users;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record UserRequestCreateDTO(
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String telephone,
        @NotNull
        @Future
        LocalDate birthday) {
}
