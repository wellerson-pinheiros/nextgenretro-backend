package com.nextgenretro.nextgenretro.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


import java.util.Objects;

@MappedSuperclass
public abstract class Product  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 300)
    private String name;

    @Column(length = 500, nullable = true)
    private String description;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private Double price;

    @Column(nullable = true)
    private String fabricante;

    @Column(length = 500, nullable = true)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnore// Certifique-se de que essa coluna existe na tabela
    protected Categoria categoria;

    // Construtor vazio
    public Product() {}

    //Construtor com argumento
    public Product( String name, String description, Double price, String imgUrl, Categoria categoria) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categoria = categoria;
    }



    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
