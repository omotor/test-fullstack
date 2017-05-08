package com.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usuarios")
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4550984509070746435L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    // FIXME Validate
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, length = 1)
    private String sexo;

    public User() {

    }

    public User(Long id, String nome, String email, String telefone, String sexo) {
        this();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}