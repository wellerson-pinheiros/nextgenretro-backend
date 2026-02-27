package com.nextgenretro.nextgenretro.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_jogos")
public class Jogos extends Product{

    @Column(nullable = true)
    private String plataforma;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_intermediaria_jogo_genero", // Nome da tabela intermediária
            joinColumns = @JoinColumn( name = "jogo_id"),  // Relacionamento com Jogo, será a fk da tabela intermediária
            inverseJoinColumns = @JoinColumn( name = "genero_id") // Relacionamento com Gênero, será a fk da tabela intermediária
    )
    private Set<GeneroJogos> generos = new HashSet<>();

    @Column(nullable = true)
    private String fachaEtaria;




    //Contrutor vázio

    public Jogos() {}

    // Construtor com argumento

    public Jogos ( String name, String description, Double price, String imgUrl, String plataforma, String fachaEtaria,Set<GeneroJogos> generos,Categoria categoria) {
        super(name, description, price, imgUrl,categoria);
        this.plataforma = plataforma;
        this.fachaEtaria = fachaEtaria;
        this.generos = generos;

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

    public Set<GeneroJogos> getGeneros() {
        return generos;
    }

    public void addGeneroJogos(GeneroJogos generoJogos) {
        this.generos.add(generoJogos);
    }

    public void removeGeneroJogos(GeneroJogos generoJogos) {
        this.generos.remove(generoJogos);
    }

}
