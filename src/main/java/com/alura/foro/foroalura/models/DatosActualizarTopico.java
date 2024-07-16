package com.alura.foro.foroalura.models;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        String curso
) {
}
