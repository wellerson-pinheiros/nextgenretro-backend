package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.repository.GeneroJogosRepository;
import com.nextgenretro.nextgenretro.model.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity <List<GeneroJogos>> findAll() {
        List<GeneroJogos> generoJogos = generoService.findAll();
        return ResponseEntity.ok().body(generoJogos);
    }
}
