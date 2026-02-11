package com.nextgenretro.nextgenretro.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_controles")
public class Controles extends Product{

    @Column(length = 300, nullable = true)
    private String tipoConexao;

    @Column(length = 300, nullable = true)
    private String originalReplica;

    @Column(length = 300, nullable = true)
    private String cor;

    public Controles() {
    }

    public Controles(Long id, String name, String description, Double price, String imgUrl, String tipoConexao, String originalReplica, String cor) {
        super(id, name, description, price, imgUrl);
        this.tipoConexao = tipoConexao;
        this.originalReplica = originalReplica;
        this.cor = cor;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public String getOriginalReplica() {
        return originalReplica;
    }

    public void setOriginalReplica(String originalReplica) {
        this.originalReplica = originalReplica;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


}
