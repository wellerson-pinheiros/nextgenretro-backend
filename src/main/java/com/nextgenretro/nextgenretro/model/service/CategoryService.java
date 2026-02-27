package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.dto.CategoriaDTO;
import com.nextgenretro.nextgenretro.model.entities.Categoria;
import com.nextgenretro.nextgenretro.model.entities.enums.CategoriaEnum;
import com.nextgenretro.nextgenretro.model.mapper.CategoriaMapper;
import com.nextgenretro.nextgenretro.model.repository.CategoryRepsotirory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepsotirory categoryRepsotirory;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public List<Categoria>  findAll(){
        return categoryRepsotirory.findAll();
    }

    public CategoriaDTO findById(long id) {
        Optional<Categoria> categoria = categoryRepsotirory.findById(id);
        categoria.orElseThrow(() -> new RuntimeException("Erro categoria"));

        return categoriaMapper.CategoriaToCategoriaDTO(categoria.get());
    }

    public CategoriaDTO findByName(String name) {
        //convertendo o DTO para string já que é um Enum

        Optional<Categoria> categoria = categoryRepsotirory.findByNomeCategoriaIgnoreCase(name);
        categoria.orElseThrow(() -> new RuntimeException("Erro categoria"));
        return categoriaMapper.CategoriaToCategoriaDTO(categoria.get());
    }

    public Categoria creat (CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaExistente = categoryRepsotirory.findByNomeCategoriaIgnoreCase(categoriaDTO.nomeCategoria());
        if (categoriaExistente.isPresent()) {
            throw new RuntimeException("Erro ao criar uma categoria");
        }
       return categoryRepsotirory.save( categoriaMapper.CategoriaDTOToCategoria(categoriaDTO));
    }
}