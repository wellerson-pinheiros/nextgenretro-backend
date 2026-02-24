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

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<JogosDTO>> findByName(@PathVariable String name) {
        List<JogosDTO> list = jogosService.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fachaetaria/{fachaetaria}")
    public  ResponseEntity<List<JogosDTO>> findByFachaetaria(@PathVariable String fachaetaria) {
        List<JogosDTO> listfachaetaria = jogosService.findByfachaEtaria(fachaetaria);
        return ResponseEntity.ok().body(listfachaetaria);
    }

    @GetMapping(value = "/pricebetween/{minPrice}/{maxPrice}")
    public ResponseEntity<List<JogosDTO>> findByPriceBetween(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        List<JogosDTO> pricebetween = jogosService.findByPrice(minPrice, maxPrice);
        return ResponseEntity.ok().body(pricebetween);
    }
}
