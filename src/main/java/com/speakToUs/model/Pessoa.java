package com.speakToUs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String nome;
    @Column(length = 30)
    private String usuario;
    @Column(length = 150)
    private String senha;
    @Column(length = 100)
    private String email;
    @Column
    private Date dtCadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
