package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.service.JogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogosController {
    @Autowired
    JogosService  jogosService;

    @GetMapping
    public ResponseEntity<List<JogosDTO>> findAll() {
        List<JogosDTO> list = jogosService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JogosDTO> findById(@PathVariable Long id) {
        JogosDTO jogosDTO = jogosService.findById(id);
        return ResponseEntity.ok().body(jogosDTO);
    }
}
