package com.nextgenretro.nextgenretro.model.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_memoryCard")
public class MemoryCard extends Product {

    @Column(length = 200, nullable = false)
    private String capacidade;

    public MemoryCard() {}

    public MemoryCard(Long id, String name, String description, Double price, String imgUrl, String capacidade) {
        super(id, name, description, price, imgUrl);
        this.capacidade = capacidade;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }


}
