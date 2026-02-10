package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.entities.MemoryCard;
import com.nextgenretro.nextgenretro.model.service.MemoryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/memorycard")
public class MemoryCardController {

    @Autowired
    private MemoryCardService memomoryCardService;

    @GetMapping
    public ResponseEntity<List<MemoryCard>> findAll(){
        List <MemoryCard> memoryCards = memomoryCardService.findAll();
        return ResponseEntity.ok().body(memoryCards);
    }
 }
