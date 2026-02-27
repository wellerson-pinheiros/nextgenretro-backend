package com.nextgenretro.nextgenretro.model.service;

import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.dto.JogosCreatDTO;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.exception.GameFachaEtariaNotFoundException;
import com.nextgenretro.nextgenretro.model.exception.GameNotFoundException;
import com.nextgenretro.nextgenretro.model.exception.GamePriceNotFoundException;
import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.entities.Jogos;
import com.nextgenretro.nextgenretro.model.mapper.JogosMapper;
import com.nextgenretro.nextgenretro.model.repository.GeneroJogosRepository;
import com.nextgenretro.nextgenretro.model.repository.JogosRepository;
import com.nextgenretro.nextgenretro.model.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class JogosService {

    @Autowired
    JogosRepository jogosRepository;

    @Autowired
    JogosMapper jogosMapper;

    @Autowired
    GeneroService generoService;


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

    public List<JogosDTO> findByGenero(String genero) {
        if(genero == null || genero.trim().isEmpty()){
            throw  new GameNotFoundException(genero);
        }
        Optional<List<Jogos>> findByGenero = jogosRepository.findByGeneros_NomeContainingIgnoreCase(genero);
        if(findByGenero.isEmpty() || findByGenero.get().isEmpty()) {
            throw new GameNotFoundException(genero);
        }
        return jogosMapper.toJogosDTO(findByGenero.get());
    }

    public Jogos create(JogosCreatDTO jogosCreatDTO) {
        //Verifica se já existe um jogo
        Optional<Jogos> jogosBuscaNome = jogosRepository.findByNameIgnoreCase(jogosCreatDTO.name().trim());
        if (jogosBuscaNome.isPresent()) {
            throw new GameNotFoundException(jogosCreatDTO.name()); // Caso exista, lança a exceção
        }
        // verificar se na lista que está vindo do parametro, O genero já existe
        Set<GeneroJogosDTO> generoAssociados = new HashSet<>();
        for (GeneroJogosDTO generoJogosDTO : jogosCreatDTO.genero()) {
            // Tenta encontrar o gênero pelo nome
            Optional<GeneroJogosDTO> generoExistente = Optional.ofNullable(generoService.findByName(generoJogosDTO.nome()));
            if (generoExistente.isPresent()) {
                // Se o gênero já existir, associa ao jogo
                generoAssociados.add(generoExistente.get());
            } else {
                // se não existir cria no banco de dados e adiciona generoAssociados para adicionar no jogo que será salvo
                generoService.create(generoJogosDTO);
                generoAssociados.add(generoJogosDTO);
            }
        }
        return jogosRepository.save(jogosMapper.jogosDTOToEntity(jogosCreatDTO));
    }

}

