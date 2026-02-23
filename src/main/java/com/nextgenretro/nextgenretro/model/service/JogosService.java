package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.dto.CategoriaDTO;
import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.entities.Jogos;
import com.nextgenretro.nextgenretro.model.mapper.JogosMapper;
import com.nextgenretro.nextgenretro.model.repository.JogosRepository;
import com.nextgenretro.nextgenretro.model.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JogosService {

    @Autowired
    JogosRepository jogosRepository;

    @Autowired
    JogosMapper jogosMapper;
    public List<JogosDTO> findAll() {
        List<Jogos> jogos = jogosRepository.findAll();
        return jogosMapper.toJogosDTO(jogos);
    }

    public JogosDTO findById(Long id) {
        Optional<Jogos> jogos = jogosRepository.findById(id);
        return jogosMapper.toJogosDTO(jogos.orElseThrow (() -> new ResourceNotFoundException(id)));
    }

}

