package com.alura.foro.foroalura.models;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   String autor,
                                   String curso) {
    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
    }
}
