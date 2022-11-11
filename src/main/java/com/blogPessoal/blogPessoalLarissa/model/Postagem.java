package com.blogPessoal.blogPessoalLarissa.model;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.*;
import com.sun.istack.NotNull;
import org.springframework.lang.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size (min = 5, max = 100, message = "Tamanho incorreto, deverá conter no mínimo 5 e máximo 100 caracteres ")
    private String titulo;

    @NotNull
    @Size (min = 3, max = 500, message = "Tamanho incorreto, deverá conter no mínimo 3 e máximo 500 caracteres")
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis()); // Captura a data e hora exata em que o dado passou por esta classe.

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
