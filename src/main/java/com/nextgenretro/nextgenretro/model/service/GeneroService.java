package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.mapper.GeneroMapper;
import com.nextgenretro.nextgenretro.model.mapper.JogosMapper;
import com.nextgenretro.nextgenretro.model.repository.GeneroJogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroJogosRepository generoJogosRepository;

    @Autowired
    private GeneroMapper generoMapper;

    public List<GeneroJogos> findAll() {
        return generoJogosRepository.findAll();
    }

    public GeneroJogosDTO findById(Long id) {
        Optional<GeneroJogos> generoJogos = generoJogosRepository.findById(id);
        if (generoJogos.isEmpty()) {
            throw new RuntimeException("Nenhum genero encontrado");
        }
        return generoMapper.generoJogosToDTO(generoJogos.get());
    }

    public GeneroJogosDTO findByName(String name) {
        Optional<GeneroJogos> generoJogos = generoJogosRepository.findByNomeIgnoreCase(name);
        if (generoJogos.isEmpty()) {
        throw new RuntimeException("Nenhum genero encontrado");
        }
        return generoMapper.generoJogosToDTO(generoJogos.get());
    }


    public GeneroJogos create (GeneroJogosDTO generoJogosDTO) {
      Optional<GeneroJogos> generoJogosbusca = generoJogosRepository.findByNomeIgnoreCase(generoJogosDTO.nome().toUpperCase());
                if (generoJogosbusca.isEmpty()) {
                 return    generoJogosRepository.save(generoMapper.GeneroJogosDTOToEntity(generoJogosDTO));
                }
                throw new RuntimeException("Genero já existe");
    }
}
