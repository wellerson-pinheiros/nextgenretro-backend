package com.nextgenretro.nextgenretro.model.mapper;

import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneroMapper {

    public GeneroJogosDTO generoJogosToDTO(GeneroJogos genenero){
        return new GeneroJogosDTO( genenero.getNome(), genenero.getDescricao());

    }

    public List<GeneroJogosDTO> generoJogosToDTOList(List<GeneroJogos> generoJogosList) {
        return generoJogosList.stream().map(this::generoJogosToDTO).collect(Collectors.toList());
        }

    public GeneroJogos GeneroJogosDTOToEntity(GeneroJogosDTO generoJogosDTO){
        return new GeneroJogos(generoJogosDTO.nome(),generoJogosDTO.descricao());
    }

}

