package com.nextgenretro.nextgenretro.model.repository;

import com.nextgenretro.nextgenretro.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepsotirory extends JpaRepository<Categoria, Long> {
}
