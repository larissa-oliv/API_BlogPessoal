package com.blogPessoal.blogPessoalLarissa.controller;


import com.blogPessoal.blogPessoalLarissa.model.*;
import com.blogPessoal.blogPessoalLarissa.repositroy.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

    @Autowired
    private PostagemRepository repository;

    @GetMapping
    public ResponseEntity <List<Postagem>>GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem>GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem>post(@RequestBody Postagem postagem){
       return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
    }

    @PutMapping
    public ResponseEntity<Postagem>put(@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
     repository.deleteById(id);
    }


}
