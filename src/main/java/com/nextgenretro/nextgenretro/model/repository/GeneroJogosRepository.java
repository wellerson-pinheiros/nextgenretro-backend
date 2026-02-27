package com.nextgenretro.nextgenretro.model.repository;



import com.nextgenretro.nextgenretro.model.entities.GeneroJogos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GeneroJogosRepository extends JpaRepository<GeneroJogos, Long> {

    // Busca um gênero por nome, ignorando maiúsculas/minúsculas
    Optional<GeneroJogos> findByNomeIgnoreCase(String nome);

    // Busca por gênero com nome contendo a palavra fornecida, ignorando maiúsculas/minúsculas
    Optional<List<GeneroJogos>> findByNomeContainingIgnoreCase(String nome);
}