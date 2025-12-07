package com.ifpi.idasecomidasthe.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password
) {
}
