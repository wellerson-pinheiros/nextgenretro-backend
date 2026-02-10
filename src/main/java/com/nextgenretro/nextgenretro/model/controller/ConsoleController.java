package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.Consoles;

import com.nextgenretro.nextgenretro.model.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value ="/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping
    public ResponseEntity<List<Consoles>> findAll() {
        List<Consoles> consoles = consoleService.findAll();
        return ResponseEntity.ok().body(consoles);
    }
}
