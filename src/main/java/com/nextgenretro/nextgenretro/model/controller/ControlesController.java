package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.Controles;
import com.nextgenretro.nextgenretro.model.service.ControlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/controles")
public class ControlesController {

    @Autowired
    private ControlesService controlesService;

    @GetMapping
    public ResponseEntity<List<Controles>> findAll(){
        List<Controles> controles = controlesService.findAll();
        return ResponseEntity.ok().body(controles);
    }
}
