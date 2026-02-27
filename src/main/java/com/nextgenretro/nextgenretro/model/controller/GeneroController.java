package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.repository.GeneroJogosRepository;
import com.nextgenretro.nextgenretro.model.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity <GeneroJogosDTO> findById(@PathVariable long id) {
        GeneroJogosDTO generoJogosDTO = generoService.findById(id);
        return ResponseEntity.ok().body(generoJogosDTO);
    }

    @PostMapping
    public ResponseEntity<GeneroJogos> createGeneroJogos(@RequestBody GeneroJogosDTO generoJogosDTO) {
        GeneroJogos generoJogos = generoService.create(generoJogosDTO);
        // Retorna a resposta HTTP com o status de 'created' (201)
        return ResponseEntity.created(URI.create("/generos/" + generoJogos.getId())).body(generoJogos);
    }
}
