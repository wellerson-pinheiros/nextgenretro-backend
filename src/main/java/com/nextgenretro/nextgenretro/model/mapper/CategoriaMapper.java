package com.nextgenretro.nextgenretro.model.mapper;

import com.nextgenretro.nextgenretro.model.dto.CategoriaDTO;
import com.nextgenretro.nextgenretro.model.entities.Categoria;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaDTO CategoriaToCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getNomeCategoria().name()
        );
    }

    public Categoria CategoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(
                categoriaDTO.nomeCategoria()
        );
        return categoria;
    }
}
