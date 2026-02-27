package com.nextgenretro.nextgenretro.model.mapper;

import com.nextgenretro.nextgenretro.model.dto.CategoriaDTO;
import com.nextgenretro.nextgenretro.model.dto.GeneroJogosDTO;
import com.nextgenretro.nextgenretro.model.dto.JogosCreatDTO;
import com.nextgenretro.nextgenretro.model.dto.JogosDTO;
import com.nextgenretro.nextgenretro.model.entities.Categoria;
import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import com.nextgenretro.nextgenretro.model.entities.Jogos;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class JogosMapper {
    public JogosDTO toJogosDTO(Jogos jogo) {
        return new JogosDTO(
                jogo.getName(),
                jogo.getDescription(),
                jogo.getPrice(),
                jogo.getFabricante(),
                jogo.getImgUrl(),
                jogo.getPlataforma(),
                jogo.getGeneros().stream()
                        .map(g -> new GeneroJogosDTO(g.getNome(), g.getDescricao()))
                        .collect(Collectors.toSet()),
                jogo.getFachaEtaria()
        );
    }

    public List<JogosDTO> toJogosDTO(List<Jogos> jogos) {
      return   jogos.stream().map(this::toJogosDTO).collect(toList());
    }

    public Jogos jogosDTOToEntity(JogosCreatDTO jogosCreatDTO) {
        // Converte a lista de gêneros do DTO para uma lista de entidades GeneroJogos
        Set<GeneroJogos> generos = jogosCreatDTO.genero().stream()
                .map(g -> new GeneroJogos(g.nome(), g.descricao())) // Aqui convertemos para a entidade GeneroJogos
                .collect(Collectors.toSet()); // Coleta em um Set

        // Converte o CategoriaDTO para Categoria
        Categoria categoria = new Categoria(
                jogosCreatDTO.categoriaDTO().nomeCategoria()
        );

        // Agora mapeamos o DTO para a entidade Jogos
        return new Jogos(
                jogosCreatDTO.name(),          // Nome do jogo
                jogosCreatDTO.description(),   // Descrição do jogo
                jogosCreatDTO.price(),         // Preço
                jogosCreatDTO.imgUrl(),        // URL da imagem
                jogosCreatDTO.plataforma(),    // Plataforma// Lista de gêneros convertidos para entidades GeneroJogos
                jogosCreatDTO.fachaEtaria(),   // Faixa etária
                generos,
                categoria // Categoria (pode precisar de conversão para entidade se necessário)
        );


    }
}