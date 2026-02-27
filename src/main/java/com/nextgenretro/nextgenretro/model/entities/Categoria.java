package com.nextgenretro.nextgenretro.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nextgenretro.nextgenretro.model.entities.enums.CategoriaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "A categoria é obrigatória")
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoriaEnum nomeCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY)
    private Set<Jogos> jogos = new HashSet<>();

    //Construtor vazio
    public Categoria() {}

    //Contrutor com argumento

   public Categoria(String nomeCategoria) {
        this.nomeCategoria = CategoriaEnum.valueOf(nomeCategoria);
   }


    // Getter and Setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoriaEnum getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(CategoriaEnum nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Set<Jogos> getJogos() {
        return  jogos;
    }

    public void addJogos(Jogos jogo) {
        this.jogos.add(jogo);
    }

    public void removeJogos(Jogos jogos) {
        this.jogos.remove(jogos);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
