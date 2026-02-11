package com.nextgenretro.nextgenretro.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "tb_console")
public class Consoles extends Product{
    @Column(length = 300, nullable = true)
    private String modelo;
    @Column(nullable = true)
    private LocalDate anoLancamento;

    public Consoles() {
    }

    public Consoles(Long id, String name, String description, Double price, String imgUrl, String modelo, LocalDate anoLancamento) {
        super(id, name, description, price, imgUrl);
        this.modelo = modelo;
        this.anoLancamento = anoLancamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


}
