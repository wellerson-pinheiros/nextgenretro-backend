package com.nextgenretro.nextgenretro.model.repository;

import com.nextgenretro.nextgenretro.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepsotirory extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c WHERE LOWER(c.nomeCategoria) = LOWER(:name)")
    Optional<Categoria> findByNomeCategoriaIgnoreCase(@Param("name") String name);
}
