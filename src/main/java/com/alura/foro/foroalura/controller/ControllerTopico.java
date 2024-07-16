package com.alura.foro.foroalura.controller;

import com.alura.foro.foroalura.models.DatosActualizarTopico;
import com.alura.foro.foroalura.models.DatosRespuestaTopico;
import com.alura.foro.foroalura.models.DatosTopico;
import com.alura.foro.foroalura.models.Topico;
import com.alura.foro.foroalura.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class ControllerTopico {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = repository.save(new Topico(datosTopico));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public Page<DatosRespuestaTopico> mostrarTodosLosTopicos(@PageableDefault(size = 5) Pageable pageable){
        return repository.findByStatusTrue(pageable).map(DatosRespuestaTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> mostrarTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarTopico(@PathVariable Long id,@RequestBody DatosActualizarTopico datosActualizartopico){
        Topico topico = repository.getReferenceById(id);
        topico.actualizarTopico(datosActualizartopico);
        System.out.println(datosActualizartopico);

        return  ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
