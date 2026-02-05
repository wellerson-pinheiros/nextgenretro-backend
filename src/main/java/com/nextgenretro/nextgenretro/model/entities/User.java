package com.nextgenretro.nextgenretro.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "tb_usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é Obrigatório")
    @Size(min = 3, max = 300, message = "O nome deve ter no minimo três caracteres e no máximo 300 caracteres!")
    private String name;
    @NotBlank(message = "O email é Obrigatório")
    @Email(message = "Email inválido!")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "A senha é Obrigatório")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres!")
    private String password;
    @Column(length = 500, nullable = true)
    private String urlImg;

    // construtor vazio
    public User(){}

    // construtor com argumento
    public User(String name, String email, String password, String urlImg) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.urlImg = urlImg;
    }

    // getter e setter

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
