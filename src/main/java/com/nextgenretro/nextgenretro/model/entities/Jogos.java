package com.nextgenretro.nextgenretro.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_jogos")
public class Jogos extends Product{
    @Column(nullable = true)
    private String plataforma;
    @Column(nullable = true)
    private String genero;
    @Column(nullable = true)
    private String fachaEtaria;

    //Contrutor vázio

    public Jogos() {}

    // Construtor com argumento

    public Jogos(Long id, String name, String description, Double price, String imgUrl, String plataforma, String genero, String fachaEtaria) {
        super(id, name, description, price, imgUrl);
        this.plataforma = plataforma;
        this.genero = genero;
        this.fachaEtaria = fachaEtaria;
    }

    //getter and setter

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFachaEtaria() {
        return fachaEtaria;
    }

    public void setFachaEtaria(String fachaEtaria) {
        this.fachaEtaria = fachaEtaria;
    }


}
