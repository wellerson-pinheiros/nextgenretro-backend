package com.nextgenretro.nextgenretro.model.mapper;

import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.entities.Jogos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class JogosMapper {
    public JogosDTO toJogosDTO(Jogos jogo) {
        return new JogosDTO(
                jogo.getId(),
                jogo.getName(),
                jogo.getDescription(),
                jogo.getPrice(),
                jogo.getFabricante(),
                jogo.getImgUrl(),
                jogo.getPlataforma(),
                jogo.getGeneros().stream()
                        .map(g -> new GeneroJogosDTO(g.getId(), g.getNome(), g.getDescricao()))
                        .collect(Collectors.toSet()),
                jogo.getFachaEtaria()
        );
    }

    public List<JogosDTO> toJogosDTO(List<Jogos> jogos) {
      return   jogos.stream().map(this::toJogosDTO).collect(toList());
    }




}