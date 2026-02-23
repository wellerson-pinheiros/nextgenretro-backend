package com.nextgenretro.nextgenretro.model.dto;

import com.nextgenretro.nextgenretro.model.entities.Jogos;

import java.util.List;

public record GeneroJogosDTO(
        Long id,
        String nome,
        String descricao
       // List<JogosDTO> jogos
) { }
