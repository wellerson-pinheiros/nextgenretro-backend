package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.repository.GeneroJogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroJogosRepository generoJogosRepository;

    public List<GeneroJogos> findAll() {
        return generoJogosRepository.findAll();
    }
}
