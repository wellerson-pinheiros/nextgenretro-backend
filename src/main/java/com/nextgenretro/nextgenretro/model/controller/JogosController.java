package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.Jogos;
import com.nextgenretro.nextgenretro.model.service.JogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogosController {
    @Autowired
    JogosService  jogosService;

    @GetMapping
    public ResponseEntity<List<Jogos>> findAll() {
        List<Jogos> list = jogosService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
