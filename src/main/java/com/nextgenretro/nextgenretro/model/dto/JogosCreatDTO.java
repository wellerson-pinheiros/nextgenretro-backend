package com.nextgenretro.nextgenretro.model.dto;

import java.util.List;
import java.util.Set;

public record JogosCreatDTO(

        String name,
        String description,
        Double price,
        String fabricante,
        String imgUrl,
        String plataforma,
        Set <GeneroJogosDTO> genero,
        String fachaEtaria,
        CategoriaDTO categoriaDTO
) {

}
