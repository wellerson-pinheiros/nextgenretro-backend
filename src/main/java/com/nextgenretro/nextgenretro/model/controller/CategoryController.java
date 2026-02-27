package com.nextgenretro.nextgenretro.model.controller;

import com.nextgenretro.nextgenretro.model.dto.CategoriaDTO;
import com.nextgenretro.nextgenretro.model.entities.Categoria;
import com.nextgenretro.nextgenretro.model.service.CategoryService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = categoryService.findAll();
        return ResponseEntity.ok().body(categorias);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        CategoriaDTO categoriaDTO = categoryService.findById(id);
        return ResponseEntity.ok().body(categoriaDTO);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity <CategoriaDTO> findByName(@PathVariable String name) {
        CategoriaDTO categoriaDTO = categoryService.findByName(name);
        return ResponseEntity.ok().body(categoriaDTO);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoriaDTOExistente = categoryService.creat(categoriaDTO);
        return ResponseEntity.ok().body(categoriaDTOExistente);
    }
}
