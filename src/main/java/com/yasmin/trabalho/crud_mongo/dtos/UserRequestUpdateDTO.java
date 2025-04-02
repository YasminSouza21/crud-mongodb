package com.yasmin.trabalho.crud_mongo.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestUpdateDTO(@NotNull
                                   Long id,
                                   @NotBlank
                                   String name,
                                   @NotBlank
                                   String telephone,
                                   @NotNull
                                   @Future
                                   String birthday) {
}
