package com.alura.foro.foroalura.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosTopico(
        Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        LocalDateTime fechaDeCreacion,
        String autor,
        boolean status,
        String curso
) {
}
