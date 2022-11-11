package com.blogPessoal.blogPessoalLarissa.controller;


import com.blogPessoal.blogPessoalLarissa.model.*;
import com.blogPessoal.blogPessoalLarissa.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UserLogin>Autetication (@RequestBody Optional<UserLogin> user){
        return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
    }
}
