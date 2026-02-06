package com.nextgenretro.nextgenretro.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_jogos")
public class Jogos extends Product{

    @Column(nullable = true)
    private String plataforma;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_intermediaria_jogo_genero", // Nome da tabela intermediária
            joinColumns = @JoinColumn( name = "jogo_id"),  // Relacionamento com Jogo, será a fk da tabela intermediária
            inverseJoinColumns = @JoinColumn( name = "genero_id") // Relacionamento com Gênero, será a fk da tabela intermediária
    )
    private List<GeneroJogos> generos;

    @Column(nullable = true)
    private String fachaEtaria;

    //Contrutor vázio

    public Jogos() {}

    // Construtor com argumento

    public Jogos(Long id, String name, String description, Double price, String imgUrl, String plataforma, String fachaEtaria) {
        super(id, name, description, price, imgUrl);
        this.plataforma = plataforma;
        this.fachaEtaria = fachaEtaria;
    }

    //getter and setter

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFachaEtaria() {
        return fachaEtaria;
    }

    public void setFachaEtaria(String fachaEtaria) {
        this.fachaEtaria = fachaEtaria;
    }

    public List<GeneroJogos> getGeneros() {
        return generos;
    }

    public void addGeneroJogos(GeneroJogos generoJogos) {
        this.generos.add(generoJogos);
    }

    public void removeGeneroJogos(GeneroJogos generoJogos) {
        this.generos.remove(generoJogos);
    }


}
