package com.blogPessoal.blogPessoalLarissa.controller;

import com.blogPessoal.blogPessoalLarissa.model.*;
import com.blogPessoal.blogPessoalLarissa.repositroy.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAllTema(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getByIdTema(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByNameTema(@PathVariable String nome){
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity <Tema> postTema (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }

    @PutMapping
    public ResponseEntity <Tema> putTema (@RequestBody Tema tema){
        return ResponseEntity.ok(repository.save(tema));
    }

    @DeleteMapping("/{id}")
    public void deleteTema(@PathVariable long id){
        repository.deleteById(id);
    }

}
