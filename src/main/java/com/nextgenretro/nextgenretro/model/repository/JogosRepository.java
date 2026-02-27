package com.nextgenretro.nextgenretro.model.repository;

import com.nextgenretro.nextgenretro.model.entities.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JogosRepository extends JpaRepository<Jogos, Long> {

   Optional<List<Jogos>> findByNameIgnoreCaseLike(String name);

   Optional<List<Jogos>> findByFachaEtariaIgnoreCaseLike(String fachaEtaria);

   Optional<List<Jogos>> findByPriceBetween(Double minPrice, Double maxPrice);

   Optional<List<Jogos>> findByGeneros_NomeContainingIgnoreCase(String genero);

    Optional<Jogos> findByNameIgnoreCase(String name);
}
