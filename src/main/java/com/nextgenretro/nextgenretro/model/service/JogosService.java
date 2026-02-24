package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.controller.exception.GameFachaEtariaNotFoundException;
import com.nextgenretro.nextgenretro.model.controller.exception.GameNotFoundException;
import com.nextgenretro.nextgenretro.model.controller.exception.GamePriceNotFoundException;
import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.entities.Jogos;
import com.nextgenretro.nextgenretro.model.mapper.JogosMapper;
import com.nextgenretro.nextgenretro.model.repository.JogosRepository;
import com.nextgenretro.nextgenretro.model.controller.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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


    public List<JogosDTO> findByName(String name) {
        if(name == null || name.trim().isEmpty()){
           throw  new GameNotFoundException(name);
        }
        Optional <List<Jogos>> jogos = jogosRepository.findByNameIgnoreCaseLike("%" + name + "%");
        if (jogos.isEmpty() || jogos.get().isEmpty()) {  // Se não encontrar nenhum jogo
            throw new GameNotFoundException(name); // Lança exceção personalizada
        }
        return jogosMapper.toJogosDTO(jogos.get());
    }

    public List<JogosDTO> findByfachaEtaria(String fachaEtaria) {
        if(fachaEtaria == null || fachaEtaria.trim().isEmpty()){
            throw  new GameNotFoundException(fachaEtaria);
        }
       Optional <List<Jogos>> jogosFachaEtaria = jogosRepository.findByFachaEtariaIgnoreCaseLike("%" + fachaEtaria + "%");
        if(jogosFachaEtaria.isEmpty() || jogosFachaEtaria.get().isEmpty()) {
            throw new GameFachaEtariaNotFoundException(fachaEtaria);
        }
        return jogosMapper.toJogosDTO(jogosFachaEtaria.get());
    }

    public List<JogosDTO> findByPrice(Double minPrice, Double maxPrice) {
        // Verificação de valores inválidos
        if (minPrice == null || minPrice < 0 || maxPrice == null || maxPrice <= 0) {
            throw new GamePriceNotFoundException(minPrice, maxPrice);
        }
        // Verifica se o intervalo é válido
        if (minPrice > maxPrice) {
            throw new GamePriceNotFoundException(minPrice, maxPrice);
        }
        Optional<List<Jogos>> findByPriceBetween = jogosRepository.findByPriceBetween(minPrice,maxPrice);
        if(findByPriceBetween.isEmpty() || findByPriceBetween.get().isEmpty()) {
            throw new GamePriceNotFoundException(minPrice, maxPrice);
        }
        return jogosMapper.toJogosDTO(findByPriceBetween.get());
    }
}

