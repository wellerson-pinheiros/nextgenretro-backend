package com.nextgenretro.nextgenretro.model.dto;

import com.nextgenretro.nextgenretro.model.entities.Categoria;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;


import java.util.Set;

public record JogosDTO(
        Long id,
        String name,
        String description,
        Double price,
        String fabricante,
        String imgUrl,
        String plataforma,
        Set<GeneroJogosDTO> generos,
        String fachaEtaria

) {
}
