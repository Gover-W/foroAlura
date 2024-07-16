package com.alura.foro.foroalura.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private String autor;
    private boolean status;
    private String curso;


    public Topico(DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fecha = datosTopico.fechaDeCreacion();
        this.autor = datosTopico.autor();
        this.status = true;
        this.curso = datosTopico.curso();
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizartopico) {
        System.out.println("entre al metoddo");
        if (datosActualizartopico.curso() != null){
            this.curso = datosActualizartopico.curso();
            System.out.println("entre al if");
        }
        if (datosActualizartopico.mensaje() != null){
            this.mensaje = datosActualizartopico.mensaje();
        }
        if (datosActualizartopico.titulo() != null){
            this.titulo = datosActualizartopico.titulo();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
