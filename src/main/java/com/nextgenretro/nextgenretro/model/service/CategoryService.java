package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.Categoria;
import com.nextgenretro.nextgenretro.model.repository.CategoryRepsotirory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepsotirory categoryRepsotirory;

    public List<Categoria>  findAll(){
        return categoryRepsotirory.findAll();
    }
}
