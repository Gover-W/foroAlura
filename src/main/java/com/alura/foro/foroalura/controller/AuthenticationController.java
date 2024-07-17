package com.alura.foro.foroalura.controller;

import com.alura.foro.foroalura.infra.security.TokenService;
import com.alura.foro.foroalura.models.DatosJWTtoken;
import com.alura.foro.foroalura.models.DatosUsuario;
import com.alura.foro.foroalura.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody DatosUsuario datosUsuario){
        Authentication token = new UsernamePasswordAuthenticationToken(datosUsuario.login(), datosUsuario.clave());
        var usuarioAutenticado = manager.authenticate(token);
        var JWTtoken = tokenService.generartoken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }
}
