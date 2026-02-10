package com.nextgenretro.nextgenretro.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_memoryCard")
public class MemoryCard extends Product {

    @Column(length = 200, nullable = false)
    private String capacidade;

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
}
