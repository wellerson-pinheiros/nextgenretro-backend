package com.nextgenretro.nextgenretro.model.dto;



import com.nextgenretro.nextgenretro.model.entities.Jogos;

import java.util.Set;

public record CategoriaDTO(
        long id,
        String nomeCategoria,
        Set<JogosDTO> jogos
) { }
